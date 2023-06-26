package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.entity.Maintainance;
import com.project.entity.Oil;
import com.project.entity.Service;
import com.project.entity.ServiceRequest;
import com.project.util.DBUtil;

public class ServiceDao implements AutoCloseable{
	
	private Connection connection;
	public ServiceDao() throws SQLException {
		this.connection=DBUtil.getConnection();
	}
	
	public ServiceRequest addNewService(String vehicle_number) throws SQLException {
		String sql = "INSERT INTO service_requests(vehicle_number) VALUES(?)";
		PreparedStatement pst = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, vehicle_number);
		pst.executeUpdate();
		ResultSet rs=pst.getGeneratedKeys();
		if(rs.next()) {
			ServiceRequest service=new ServiceRequest(rs.getInt(1),vehicle_number);
			return service;
		}
		return null;
	
	}
	
	public List<ServiceRequest> fetchTodaysServiceList() throws SQLException {
		String sql="SELECT id,vehicle_number,DATE(request_date)as 'request_date',bill_amount FROM service_requests WHERE DATE(request_date)=DATE(SYSDATE())";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		List<ServiceRequest>serviceList=new ArrayList<>();
		while(rs.next()) {
			ServiceRequest serviceReq=new ServiceRequest(rs.getInt("id"),rs.getString("vehicle_number"),rs.getDate("request_date"),rs.getDouble("bill_amount"));
			serviceList.add(serviceReq);
		}
		return serviceList;
	} 
	
	public List<Service> serviceProvided(ServiceRequest serviceRequest) throws SQLException {
		String sql="SELECT * FROM services WHERE service_request_id=?";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setInt(1, serviceRequest.getId());
		ResultSet rs= pst.executeQuery();
		serviceRequest.setServiceList(new ArrayList<>());
		while(rs.next()) {
			if(rs.getString("type").equals("maintainance")) {
				Service maintainance=new Maintainance(rs.getInt("id"),
						rs.getString("type"),
						rs.getDouble("labour_charges"),
						rs.getDouble("total_cost"),
						rs.getString("remark"),
						rs.getInt("service_request_id"));
						
				serviceRequest.getServiceList().add(maintainance);
			}
			else{
				Service oil=new Oil(rs.getInt("id"),
						rs.getString("type"),
						rs.getDouble("oil_cost"),
						rs.getDouble("total_cost"),
						rs.getString("remark"),
						rs.getInt("service_request_id"));
				
				serviceRequest.getServiceList().add(oil);
			}
		}
		return serviceRequest.getServiceList();
	}
	
	public void addService(Service service) throws SQLException {
		String sql="INSERT INTO services(type,labour_charges,oil_cost,total_cost,remark,service_request_id) VALUES (?,?,?,?,?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		if(service instanceof Maintainance) {
			pst.setString(1, "maintainance");
			pst.setDouble(2, ((Maintainance)service).getLabourCharges());
			pst.setDouble(3, 0);
			pst.setDouble(4, service.getTotal_cost());
			pst.setString(5, service.getRemark());
			pst.setInt(6, service.getService_request_id());
			pst.executeUpdate();
		}
		else {
			pst.setString(1, "oil");
			pst.setDouble(3, ((Oil)service).getOil_cost());
			pst.setDouble(2, 0);
			pst.setDouble(4, service.getTotal_cost());
			pst.setString(5, service.getRemark());
			pst.setInt(6, service.getService_request_id());
			pst.executeUpdate();
		}
		
		
		
	}
	public void updateServices(Service service) throws SQLException {
		String sql="UPDATE services SET labour_charges=?,remark=?,total_cost=? WHERE id=? ";
		System.out.println(service.getTotal_cost());
		try(PreparedStatement pst=this.connection.prepareStatement(sql)){
			if(service instanceof Maintainance) {
				pst.setDouble(1, ((Maintainance)service).getLabourCharges());
				pst.setString(2, service.getRemark());
				System.out.println(((Maintainance)service).getTotal_cost());
			
				pst.setDouble(3, ((Maintainance)service).getTotal_cost());
				pst.setInt(4,service.getId());
				pst.executeUpdate();
			}
		}
		
	}

	@Override
	public void close() throws Exception {
		
		
	}

	

}
