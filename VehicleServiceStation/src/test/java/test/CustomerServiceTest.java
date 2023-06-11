package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.project.dao.CustomerDao;
import com.project.entity.Customer;
import com.project.service.CustomerService;

class CustomerServiceTest {

//	@Test
//	void testGetAllCustomer() {
//		CustomerService.getAllCustomer();
//	}

//	 @Test
//	 void testAddCustomer() {
//		 CustomerService.addCustomer();
//	 }
//	@Test
//	void testSpecificCustomer() {
//		CustomerService.getSpecificCustomer();
//	}

	@Test
	 void testUpdateCustomer() {
		CustomerService.updateCustomer();
	}
	

}
