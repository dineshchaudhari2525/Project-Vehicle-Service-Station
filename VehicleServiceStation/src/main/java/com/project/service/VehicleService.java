package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.project.dao.CustomerDao;
import com.project.dao.VehicleDao;
import com.project.entity.Customer;
import com.project.entity.CustomerVehicle;
import com.project.entity.SpecificCustomerVehicles;
import com.project.entity.Vehicle;

public class VehicleService {

	public static void addVehicle() {
//		CustomerService.getSpecificCustomer();
		try {  Customer customer=CustomerService.getSpecificCustomer();
	    if(customer!=null)
	    {
	    	System.out.println("Enter Vehicle Number: ");
	    	String vehicleNo=new Scanner (System.in).next();
	    	getAllVehicle();
	    	System.out.println("Select the Vehicle=>");
	    	System.out.println("Enter the vehicle id Or Enter 0 for adding the company & model...");
	    	int id =new Scanner(System.in).nextInt();

	    	if (id==0) {

					System.out.println("Enter Company Name:  ");
					String company=new Scanner(System.in).next();
					System.out.println("Enter Company Model:  ");
					String model=new Scanner(System.in).next();
					VehicleDao vehicleDao=new VehicleDao();
			
						vehicleDao.addVehicle(new Vehicle(company,model));
				
					System.out.println("#### Vehicle  Added####  ");
				}
	    	else {
	    		VehicleDao vehicleDao=new VehicleDao();
				
				vehicleDao.customerVehicle(new CustomerVehicle(vehicleNo,customer.getId(),id));
	    		
	    		System.out.println("#### Vehicle  Added####  ");
	    	}
	    	
			}

	    else {
	    	CustomerService.addCustomer();
	    }	
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
}


		public static void getAllVehicle() {
			List<Vehicle>vehicleList=new ArrayList<>();
			try (VehicleDao vehicleDao = new VehicleDao()) {
				vehicleDao.getAllVehicle(vehicleList);
				for(Vehicle vehicle:vehicleList) {
					System.out.println(vehicle);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
	}
	
		public static void getSpecificVehicles() {
			Customer cust = CustomerService.getSpecificCustomer();
			
			try (VehicleDao vehicleDao = new VehicleDao()) {
				List<SpecificCustomerVehicles> vehicles = vehicleDao.specificCustomerVehicles(cust.getId());
				System.out.println("### All the vehicles for customer: "+cust.getName()+" "+cust.getMobile());
				for (SpecificCustomerVehicles v : vehicles) {
					System.out.println(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	public static void updateVehicle() {
		System.out.println("Enter Vehicle id to edit vehicle details: ");
		int id =new Scanner (System.in).nextInt();
		System.out.println("Enter Vehicle model : ");
		String model =new Scanner (System.in).next();
		try(VehicleDao vehicleDao=new VehicleDao()){
			if(vehicleDao.updateVehicle(id,model)>0)
				System.out.println("Vehicle Data Updated Successfully");
			else
				System.out.println("Vehicle Not Found");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteVehicle() {
		System.out.println("Enter Vehicle id to delete details: ");
		int id=new Scanner(System.in).nextInt();
		try {
			VehicleDao vehicleDao =new VehicleDao(); {
				if(vehicleDao.deleteVehicle(id)>0)
					System.out.println("Vehicle Data Deleted successfully");
				else
					System.out.println("Vehicle data not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
