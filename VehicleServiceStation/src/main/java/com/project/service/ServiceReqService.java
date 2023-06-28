package com.project.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.project.dao.ServiceReqDao;
import com.project.dao.VehicleDao;
import com.project.entity.Customer;
import com.project.entity.CustomerVehicle;
import com.project.entity.SpecificCustomerVehicles;
import com.project.entity.Vehicle;
import com.project.main.SubMenu;

public class ServiceReqService {



	public static String selectCustomerVehilcle() {
		Customer cust = CustomerService.getSpecificCustomer();
		List<SpecificCustomerVehicles> vehicles=VehicleService.getSpecificVehicles(cust);
		for(int i=0;i<vehicles.size();i++)
		{
			System.out.println((i+1)+" "+vehicles.get(i));
		}
		System.out.println("Is this New Vehicle? if yes press 0 otherwise press 1 ");
		int choice = new Scanner(System.in).nextInt();
		if (choice == 1) {
		
			System.out.println("Choose vehicle index from the list ");
			int vehicleSeq = new Scanner(System.in).nextInt();
			
			return vehicles.get(vehicleSeq-1).getVehicle_number();
		} 
		else {
			
			System.out.println("Enter vehicle number:");
			String vehicleNumber=new Scanner(System.in).next();
			List<Vehicle> vehiclesList=VehicleService.getAllVehicle();
			System.out.println("Enter vehicle id:");
			int vehicleId=new Scanner(System.in).nextInt();
			CustomerVehicle customervehicle=new CustomerVehicle(vehicleNumber, cust.getId(), vehicleId);
		
			try(VehicleDao vehicleDao=new VehicleDao();) {
				vehicleDao.customerVehicle(customervehicle);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			System.out.println("Please again Enter 0 to go back and 1st Insert cutomer_vehicles");
		}
		return null;
	}
	
  
}
