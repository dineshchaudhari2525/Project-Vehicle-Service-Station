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
		String sql="INSERT INTO customer(name,mobile,email,address) VALUES(?,?,?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setString(1, customer.getName());
		pst.setString(2, customer.getMobile());
		pst.setString(3, customer.getEmail());
		pst.setString(4, customer.getAddress());
		int cnt=pst.executeUpdate();
		return cnt;
	}
	
	public Customer getSpecificCustomer(String mobile) throws SQLException {
		String sql="SELECT * FROM customer WHERE mobile=?";
		try(PreparedStatement getSpecificCustomer=this.connection.prepareStatement(sql)){
			getSpecificCustomer.setString(1, mobile);
			ResultSet rs= getSpecificCustomer.executeQuery();
			if(rs.next()) {
				return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			return null;
		}
	}
	
	public int updateCustomer(int id,String mobile,String address,String name) throws SQLException {
		String sql="UPDATE customer SET mobile =? ,address=? ,name=?WHERE id=?";
		try(PreparedStatement updateCustomer=this.connection.prepareStatement(sql)){
			updateCustomer.setInt(4, id);
			updateCustomer.setString(1, mobile);
			updateCustomer.setString(2, address);
			updateCustomer.setString(3, name);
			return updateCustomer.executeUpdate();
		}
	}
	public int deleteCustomer(int id) throws SQLException {
		String sql="DELETE FROM customer WHERE id=? ";
		try(PreparedStatement deleteCustomer=this.connection.prepareStatement(sql)){
			deleteCustomer.setInt(1, id);
			return deleteCustomer.executeUpdate();
		}
	}
	@Override
	public void close() throws SQLException {
		this.connection.close();
		
	}

}
