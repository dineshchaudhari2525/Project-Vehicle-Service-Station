package test;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.project.dao.CustomerDao;
import com.project.dao.VehicleDao;
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

}
