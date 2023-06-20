package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.entity.Service;
import com.project.util.DBUtil;

public class ServiceDao implements AutoCloseable{
	
	private Connection connection;
	public ServiceDao() throws SQLException {
		this.connection=DBUtil.getConnection();
	}
	
	public Service addNewService(String vehicle_number) throws SQLException {
		String sql = "INSERT INTO service_requests(vehicle_number) VALUES(?)";
		PreparedStatement pst = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, vehicle_number);
		pst.executeUpdate();
		ResultSet rs=pst.getGeneratedKeys();
		if(rs.next()) {
			Service service=new Service(rs.getInt(1),vehicle_number);
			return service;
		}
		return null;
		
	
	}

	@Override
	public void close() throws Exception {
		
		
	}

}
