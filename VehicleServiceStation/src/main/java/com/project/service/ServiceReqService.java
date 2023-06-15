package com.project.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.dao.VehicleDao;
import com.project.entity.Customer;
import com.project.entity.CustomerVehicle;
import com.project.entity.Vehicle;

public class ServiceReqService {
	
	public static String selectCustomerVehilcle() {
		
		VehicleService.getSpecificVehicles();
		System.out.println("Choose vehicle_number from the list or input details of new vehicle");
		String vehicleNumber = new Scanner(System.in).next();
	   return vehicleNumber;
		
//		if (vehicleNumber == null) {
////			System.out.println("Enter vehicle number=> ");
////			String vehicle_number=new Scanner (System.in).nextInt();
//			System.out.println("Enter customer id=> ");
//			int customer_id=new Scanner (System.in).nextInt();
//			System.out.println("Enter vehicle id=> ");
//			int vehicle_id=new Scanner (System.in).nextInt();

//			VehicleService.getAllVehicle();
//	    	System.out.println("Select the Vehicle=>");
//	    	System.out.println("Enter the vehicle id Or Enter 0 for adding the company & model...");
//	    	int id =new Scanner(System.in).nextInt();

//	    	if (id==0) {
//
//					System.out.println("Enter Company Name:  ");
//					String company=new Scanner(System.in).next();
//					System.out.println("Enter Company Model:  ");
//					String model=new Scanner(System.in).next();
//					VehicleDao vehicleDao=new VehicleDao();
//			
//						vehicleDao.addVehicle(new Vehicle(company,model));
//				
//					System.out.println("#### Vehicle  Added####  ");
//				}
//	    	else {
//	    		VehicleDao vehicleDao=new VehicleDao();
//				
//				vehicleDao.customerVehicle(new CustomerVehicle(vehicleNumber));
//	    		
//	    		System.out.println("#### Vehicle  Added####  ");
//	    	}
//	    	
//			}

		}
	public static void processRequest() {
		if(selectCustomerVehilcle()==null) {
			System.out.println("First Select Customer Vehicle");
		}
		
	}
		
		
	
	

}
