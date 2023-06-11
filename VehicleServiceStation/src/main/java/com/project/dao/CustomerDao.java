package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.entity.Customer;
import com.project.util.DBUtil;

public class CustomerDao implements AutoCloseable {
	private Connection connection;
	
	public CustomerDao() throws SQLException {
		this.connection=DBUtil.getConnection();
	}
	public void getAllCustomer(List<Customer>customerList) throws SQLException {
		String sql="SELECT * From customer";
		
		try(PreparedStatement getCustomer =this.connection.prepareStatement(sql)){
			ResultSet rs=getCustomer.executeQuery();
			while(rs.next()) {
				Customer customer= new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				customerList.add(customer);
			}
		}
	}
	
	public int addCustomer(Customer customer) throws SQLException {
		String sql="INSERT INTO customer(id,name,mobile,email,adddress)VALUES(?,?,?,?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setInt(1, customer.getId());
		pst.setString(2, customer.getName());
		pst.setString(3, customer.getMobile());
		pst.setString(4, customer.getEmail());
		pst.setString(5, customer.getAddress());
		return 0;
	}
	
	public Customer getSpecificCustomer(String mobile) throws SQLException {
		String sql="SELECT * FROM customer WHERE mobile=?";
		try(PreparedStatement getSpecificCustomer=this.connection.prepareStatement(sql)){
			getSpecificCustomer.setString(1, mobile);
			ResultSet rs= getSpecificCustomer.executeQuery();
			if(rs.next())
				return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			    return null;
		}
	}
	
	public int updateCustomer(int id,String mobile,String address) throws SQLException {
		String sql="UPDATE customer SET mobile =? ,address=? WHERE id=?";
		try(PreparedStatement updateCustomer=this.connection.prepareStatement(sql)){
			updateCustomer.setInt(3, id);
			updateCustomer.setString(1, mobile);
			updateCustomer.setString(2, address);
			return updateCustomer.executeUpdate();
		}
	}
	@Override
	public void close() throws SQLException {
		this.connection.close();
		
	}

}
