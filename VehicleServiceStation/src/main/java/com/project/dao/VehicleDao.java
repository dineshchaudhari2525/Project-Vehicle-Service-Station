package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	@Override
	public void close() throws SQLException {
		this.connection.close();
	}

}
