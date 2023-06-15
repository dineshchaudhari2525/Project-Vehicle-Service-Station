package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.project.dao.CustomerDao;
import com.project.dao.VehicleDao;
import com.project.entity.Customer;
import com.project.entity.CustomerVehicle;
import com.project.entity.Vehicle;

public class VehicleDaoTest {
	@Test
	public void testAddVehicle() {
		VehicleDao vehicleDao;
		try {
			vehicleDao = new VehicleDao();
			System.out.println(vehicleDao.addVehicle(new Vehicle("Ford","Aspire")));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSpecificCustomerVehicles() {
		VehicleDao vehicleDao;
		try {
			vehicleDao = new VehicleDao();
			System.out.println(vehicleDao.specificCustomerVehicles(2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllVehicle() {
		
		List<Vehicle> vehicle=new ArrayList<>();
		VehicleDao vehicleDao;
		try {
			vehicleDao = new VehicleDao();
			vehicleDao.getAllVehicle(vehicle);
			vehicle.forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

   
//testAddVehicle() case from VehicleDao tested successfully
