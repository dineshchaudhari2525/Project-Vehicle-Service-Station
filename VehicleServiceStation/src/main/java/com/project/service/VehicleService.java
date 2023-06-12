package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.dao.CustomerDao;
import com.project.dao.VehicleDao;
import com.project.entity.Vehicle;

public class VehicleService {

	public static void addVehicle() {
		System.out.println("Enter id to add Vehicle: ");
		int id=new Scanner(System.in).nextInt();
		System.out.println("Enter company to add Vehicle: ");
		String company=new Scanner(System.in).next();
		System.out.println("Enter model to add Vehicle: ");
		String model=new Scanner(System.in).next();
		Vehicle vehicle=new Vehicle(id,company,model);
		
		try(VehicleDao vehicleDao = new VehicleDao()){
			if(vehicleDao.addVehicle(vehicle)>0)
				System.out.println("#####Vehicle Details Inserted Successfully#####");
			else
			 System.out.println("Vehicle details not Inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void getAllVehicle() {
		List<Vehicle>vehicleList=new ArrayList<>();
		try (VehicleDao vehicleDao = new VehicleDao()) {
			vehicleDao.getAllVehicle(vehicleList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}
	public static void getSpecificVehicle() {
		System.out.println("Enter id to get Vehicle Details: ");
		int id=new Scanner(System.in).nextInt();
		try(VehicleDao vehicleDao=new VehicleDao()){
			Vehicle vehicle=vehicleDao.getSpecificVehicle(id);
			if(vehicle!=null)
				System.out.println(vehicle);
			else
				System.out.println("Vehicle Not Found");
		}catch(SQLException e) {
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
