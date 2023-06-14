package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.project.dao.CustomerDao;
import com.project.entity.Customer;

public class CustomerDaoTest {
	@Test
	public void testGetAllCustomers()
	{
		try {
			List<Customer> customer=new ArrayList<>();
			CustomerDao customerDao=new CustomerDao();
			customerDao.getAllCustomer(customer);
			System.out.println(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAddCustomer() {
		CustomerDao customerDao;
		try {
			customerDao = new CustomerDao();
			System.out.println(customerDao.addCustomer(new Customer("abc", "26595754512", "abc@gmail.com", "pune")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testGetSpecificCustomer() {
		CustomerDao customerDao;
		try {
			customerDao = new CustomerDao();
			System.out.println(customerDao.getSpecificCustomer("70570071000"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testUpdateCustomer() {
		CustomerDao customerDao;
		try {
			customerDao=new CustomerDao();
			System.out.println(customerDao.updateCustomer(13, "9975779661", "Pune", "DineshRC"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDeleteCustomer(){
		CustomerDao customerDao;
		try {
			customerDao=new CustomerDao();
			System.out.println(customerDao.deleteCustomer(12));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
