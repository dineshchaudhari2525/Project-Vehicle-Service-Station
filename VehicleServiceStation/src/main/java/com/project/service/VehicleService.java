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
		try {
			Customer customer = CustomerService.getSpecificCustomer();
			if (customer != null) {
				System.out.println("Enter Vehicle Number: ");
				String vehicleNo = new Scanner(System.in).next();
				getAllVehicle();
				System.out.println("Select the Vehicle=>");
				System.out.println("Enter the vehicle id Or Enter 0 for adding the company & model...");
				int id = new Scanner(System.in).nextInt();

				if (id == 0) {

					System.out.println("Enter Company Name:  ");
					String company = new Scanner(System.in).next();
					System.out.println("Enter Company Model:  ");
					String model = new Scanner(System.in).next();
					VehicleDao vehicleDao = new VehicleDao();

					vehicleDao.addVehicle(new Vehicle(company, model));

					System.out.println("#### Vehicle  Added####  ");
				} else {
					VehicleDao vehicleDao = new VehicleDao();

					vehicleDao.customerVehicle(new CustomerVehicle(vehicleNo, customer.getId(), id));

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

	public static 	List<Vehicle>  getAllVehicle() {
		List<Vehicle> vehicleList = new ArrayList<>();
		try (VehicleDao vehicleDao = new VehicleDao()) {
			vehicleDao.getAllVehicle(vehicleList);
			for (Vehicle vehicle : vehicleList) {
				System.out.println(vehicle);
			}
			return vehicleList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<SpecificCustomerVehicles> getSpecificVehicles(Customer cust) {
		
		List<SpecificCustomerVehicles> vehicles=null;
		try (VehicleDao vehicleDao = new VehicleDao()) {
			 vehicles = vehicleDao.specificCustomerVehicles(cust.getId());
			System.out.println("### All the vehicles for customer => " + cust.getName() + " " + cust.getMobile());
			//System.out.println("");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	public static void updateVehicle() {
		System.out.println("Enter old Vehicle number => ");
		String old_vehicle_number = new Scanner(System.in).next();
		try {
			if (old_vehicle_number != null) {
				VehicleDao vehicleDao = new VehicleDao();
				System.out.println("Enter New Vehicle number => ");
				String New_vehicle_number = new Scanner(System.in).next();
				System.out.println(vehicleDao.updateCustomerVehicle(old_vehicle_number, New_vehicle_number));
				System.out.println("Vehicle Number Updated successfully");
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteVehicle() {
		Customer cust = CustomerService.getSpecificCustomer();
		getSpecificVehicles(cust);
		System.out.println("Enter Vehicle number to delete details: ");
		String vehicle_number = new Scanner(System.in).next();
		try {
			VehicleDao vehicleDao = new VehicleDao();
			{
				if (vehicleDao.deleteVehicle(vehicle_number) > 0)
					System.out.println("Vehicle  Deleted successfully");
				else
					System.out.println("Vehicle  not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
