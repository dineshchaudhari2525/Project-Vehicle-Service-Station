package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.entity.Employee;
import com.project.utility.DBUtil;

public class empDao implements AutoCloseable {
	
	private Connection connection;
	
	public empDao() throws SQLException {
		this.connection=DBUtil.getConnection();
	}
	public int addEmployee(Employee employee) throws SQLException {
		String sql="INSERT INTO EMP(ename,job,mgr,sal,deptno) VALUES(?,?,?,?,?)";
		PreparedStatement pst=this.connection.prepareStatement(sql);
		pst.setString(1, employee.getEname());
		pst.setString(2, employee.getJob());
		pst.setInt(3, employee.getMgr());
		pst.setDouble(4, employee.getSal());
		pst.setInt(5, employee.getDeptno());
		int cnt=pst.executeUpdate();
		return cnt;
	}
	
	

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
