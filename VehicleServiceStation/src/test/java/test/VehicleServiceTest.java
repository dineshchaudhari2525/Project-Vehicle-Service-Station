package test;

import org.junit.jupiter.api.Test;

import com.project.service.VehicleService;

public class VehicleServiceTest {
	
	@Test
	void testAddVehicle(){
		VehicleService.addVehicle();
	}
	@Test
	void testAllVehicle() {
		VehicleService.getAllVehicle();
	}
	@Test
	void testGetSpecificVehicles() {
		VehicleService.getSpecificVehicles();
	}
	@Test
	void testUpdateVehicle() {
		VehicleService.updateVehicle();
	}
	@Test
	void testDeleteVehicle() {
		VehicleService.deleteVehicle();
	}

}
