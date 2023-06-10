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
}
