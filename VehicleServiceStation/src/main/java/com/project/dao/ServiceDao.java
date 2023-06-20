package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public void close() throws Exception {
		
		
	}

}
