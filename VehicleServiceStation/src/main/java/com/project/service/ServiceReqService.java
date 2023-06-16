package com.project.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.dao.ServiceReqDao;
import com.project.dao.VehicleDao;
import com.project.entity.Customer;
import com.project.entity.CustomerVehicle;
import com.project.entity.Vehicle;
import com.project.main.SubMenu;

public class ServiceReqService {

	public static String selectCustomerVehilcle() {

		VehicleService.getSpecificVehicles();
		System.out.println("Is this New Vehicle? if yes press 0 otherwise press 1 ");
		int choice = new Scanner(System.in).nextInt();
		if (choice == 1) {
			System.out.println("Choose vehicle_number from the list or input details of new vehicle=> ");
			String vehicleNumber = new Scanner(System.in).next();
			return vehicleNumber;
		} 
		else {
			System.out.println("Please again Enter 0 to go back and 1st Insert cutomer_vehicles");
			return null;
		}

	}
	
//	public static void  newService() {
//		ServiceReqDao serviceReqDao;
//		serviceReqDao=new ServiceReqDao();
//	}

}
