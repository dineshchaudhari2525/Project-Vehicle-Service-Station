package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.entity.Parts;
import com.project.entity.Vehicle;
import com.project.util.DBUtil;

public class PartsDao implements AutoCloseable {

private Connection connection;
	
	public PartsDao() throws SQLException {
		this.connection=DBUtil.getConnection();
	}
	public int addParts(Parts parts) throws SQLException {
		String sql="INSERT INTO parts(id,name,description,price) VALUES(?,?,?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setInt(1, parts.getId());
		pst.setString(2, parts.getName());
		pst.setString(3, parts.getDescription());
		pst.setDouble(4, parts.getPrice());
		int cnt=pst.executeUpdate();
		return cnt;
	}
	
	public void getAllParts(List<Parts>partsList) throws SQLException {
		String sql="SELECT * FROM parts";
		try(PreparedStatement getParts=this.connection.prepareStatement(sql)){
			ResultSet rs=getParts.executeQuery();
			while(rs.next()) {
				Parts parts=new Parts(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getDouble("price"));
				partsList.add(parts);
			}
		}
	}
	@Override
	public void close() throws SQLException {
		this.connection.close();
		
	}


}
