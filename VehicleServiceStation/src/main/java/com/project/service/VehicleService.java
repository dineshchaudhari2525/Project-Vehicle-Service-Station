package com.project.service;

import java.sql.SQLException;
import java.util.Scanner;

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
	
}
