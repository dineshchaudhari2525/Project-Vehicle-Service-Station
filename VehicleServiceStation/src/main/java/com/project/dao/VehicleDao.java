package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.entity.Customer;
import com.project.entity.CustomerVehicle;
import com.project.entity.SpecificCustomerVehicles;
import com.project.entity.Vehicle;
import com.project.util.DBUtil;

public class VehicleDao implements AutoCloseable {
private Connection connection;
	
	public VehicleDao() throws SQLException {
		this.connection = DBUtil.getConnection();
	}
	
	public int addVehicle(Vehicle vehicle) throws SQLException {
    	String sql="INSERT INTO vehicle(company,model) VALUES(?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setString(1, vehicle.getCompany());
		pst.setString(2, vehicle.getModel());
		int cnt=pst.executeUpdate();
		return cnt;
	}
	public int customerVehicle(CustomerVehicle customerVehicle) throws SQLException {
		String sql="INSERT INTO customer_vehicles(vehicle_number,customer_id,vehicle_id) VALUES(?,?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setString(1, customerVehicle.getVehicle_number());
		pst.setInt(2, customerVehicle.getCustomer_id());
		pst.setInt(3, customerVehicle.getVehicle_id());
		int cnt=pst.executeUpdate();
		return cnt;
	}
	
	public List<SpecificCustomerVehicles> specificCustomerVehicles(int customer_id) throws SQLException {
		String sql="SELECT * FROM customer_vehicles cv INNER JOIN vehicle v ON cv.vehicle_id=v.id WHERE customer_id=?";
		PreparedStatement pst = this.connection.prepareStatement(sql);
		pst.setInt(1, customer_id);
	    ResultSet rs = pst.executeQuery();
	    List<SpecificCustomerVehicles> specificVehicles = new ArrayList<>();
	    while (rs.next()) {
	    	SpecificCustomerVehicles scv = new SpecificCustomerVehicles(rs.getString("vehicle_number"),
	    			rs.getInt("customer_id"),
	    			rs.getInt("vehicle_id"),
	    			rs.getString("company"),
	    			rs.getString("model"));
	    	
	    	specificVehicles.add(scv);
	    }
	    return specificVehicles;
	}
	public void getAllVehicle(List<Vehicle>vehicleList) throws SQLException {
		String sql="SELECT * FROM vehicle";
		try(PreparedStatement getVehicle=this.connection.prepareStatement(sql)){
			ResultSet rs=getVehicle.executeQuery();
			while(rs.next()) {
				Vehicle vehicle=new Vehicle(rs.getInt(1),rs.getString(2),rs.getString(3));
				vehicleList.add(vehicle);
			}
		}
	}
	
	public Vehicle getSpecificVehicle(int id) throws SQLException{
		String sql="SELECT * FROM vehicle WHERE id=?";
		try(PreparedStatement getSpecificVehicle=this.connection.prepareStatement(sql)){
			getSpecificVehicle.setInt(1, id);
			ResultSet rs= getSpecificVehicle.executeQuery();
			if(rs.next())
				return new Vehicle(rs.getInt("id"),rs.getString("company"),rs.getString("model"));
			  
			
		}
		  return null;
	}
	
	
	public int updateVehicle(int id,String model) throws SQLException {
		String sql="UPDATE vehicle SET model =? WHERE id=?";
		try(PreparedStatement updateVehicle=this.connection.prepareStatement(sql)){
			updateVehicle.setInt(3, id);
			updateVehicle.setString(1, model);
	
			return updateVehicle.executeUpdate();
		}
	}
	public int deleteVehicle(int id) throws SQLException {
		String sql="DELETE FROM customer WHERE id=? ";
		try(PreparedStatement deleteVehicle=this.connection.prepareStatement(sql)){
			deleteVehicle.setInt(1, id);
			return deleteVehicle.executeUpdate();
		}
	}
	@Override
	public void close() throws SQLException {
		this.connection.close();
	}

}
