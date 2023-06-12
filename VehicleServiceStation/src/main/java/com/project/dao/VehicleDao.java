package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.entity.Customer;
import com.project.entity.Vehicle;
import com.project.util.DBUtil;

public class VehicleDao implements AutoCloseable {
private Connection connection;
	
	public VehicleDao() throws SQLException {
		this.connection=DBUtil.getConnection();
	}
	
	public int addVehicle(Vehicle vehicle) throws SQLException {
		String sql="INSERT INTO vehicle(id,company,model) VALUES(?,?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setInt(1, vehicle.getId());
		pst.setString(2, vehicle.getCompany());
		pst.setString(3, vehicle.getModel());
		int cnt=pst.executeUpdate();
		return cnt;
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
	@Override
	public void close() throws SQLException {
		this.connection.close();
	}

}
