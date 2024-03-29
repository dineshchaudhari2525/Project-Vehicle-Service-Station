package com.project.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
import com.project.util.DBUtil;
public class ServiceReqDao implements AutoCloseable {
private Connection connection;
	
	public ServiceReqDao() throws SQLException {
		this.connection = DBUtil.getConnection();
	}
	
	public void vehicleRegister(String vehicle_number,int customer_id,int vehicle_id) throws SQLException {
		String sql="INSERT INTO customer_vehicles(vehicle_number,customer_id,vehicle_id) VALUES(?,?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setString(1,vehicle_number);
		pst.setInt(2,customer_id);
		pst.setInt(3,vehicle_id);
	}
	
		
	@Override
	public void close() throws SQLException {
		this.connection.close();
	}

	public int addBill(double bill, int id) throws SQLException {
	
		String sql="UPDATE service_requests SET bill_amount=? WHERE id=?";
		try(PreparedStatement addBill=this.connection.prepareStatement(sql)){
			addBill.setDouble(1, bill);
			addBill.setInt(2, id);
			return addBill.executeUpdate();
		}

	}


}
