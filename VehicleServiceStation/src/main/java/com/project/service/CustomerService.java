package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.dao.CustomerDao;
import com.project.entity.Customer;

public class CustomerService {
	public static void getAllCustomer() {
		
		List<Customer>customerList=new ArrayList<>();
		try(CustomerDao customerDao = new CustomerDao()){
				customerDao.getAllCustomer(customerList);
				for(Customer customer : customerList) 
					System.out.println(customer);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void addCustomer() {
		System.out.println("Enter id to add Customer Details : ");
		int id=new Scanner (System.in).nextInt();
		System.out.println("Enter customer name  : ");
		String name=new Scanner(System.in).next();
		System.out.println("Enter customer mobile  : ");
		String mobile=new Scanner(System.in).next();
		System.out.println("Enter customer email  : ");
		String email=new Scanner(System.in).next();
		System.out.println("Enter customer address  : ");
		String address=new Scanner(System.in).next();
	 	Customer customer=new Customer(id,name,mobile,email,address);
        try(CustomerDao customerDao = new CustomerDao()){
			
			if(customerDao.addCustomer(customer)>0)
				System.out.println("####Customer Details Inserted Successfully####");
			else
				System.out.println("Customer Details not Inserted");
		}catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}

