package com.project.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.dao.empDao;
import com.project.entity.Employee;

public class EmpService {
	public static void addEmployee() throws Exception {
		System.out.println("Enter employee name: ");
		String name=new Scanner(System.in).next();
		System.out.println("Enter employee job: ");
		String job=new Scanner(System.in).next();
		System.out.println("Enter employee mgr: ");
		int mgr=new Scanner(System.in).nextInt();
		System.out.println("Enter employee sal: ");
		Double sal=new Scanner(System.in).nextDouble();
		System.out.println("Enter employee deptno: ");
		int deptno=new Scanner(System.in).nextInt();
		Employee employee=new Employee(name,job,mgr,sal,deptno);
		try(empDao empDao=new empDao()){
			if(empDao.addEmployee(employee)>0)
				System.out.println("Data Inserted");
			else
				System.out.println("data not inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
