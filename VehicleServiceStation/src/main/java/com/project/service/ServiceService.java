package com.project.service;

import java.sql.SQLException;
import java.util.List;

import com.project.dao.ServiceDao;
import com.project.dao.ServiceReqDao;
import com.project.entity.ServiceRequest;

public class ServiceService {
	public static ServiceRequest newService(String vehicle_number) throws SQLException {
		ServiceDao serviceDao;
		serviceDao = new ServiceDao();
		return serviceDao.addNewService(vehicle_number);

	}
	
	public static List<ServiceRequest> fetchTodaysServiceList() throws SQLException {
		ServiceDao serviceDao=new ServiceDao();

		List<ServiceRequest> serviceList= serviceDao.fetchTodaysServiceList();
		//List<ServiceRequest> serviceList=null;
		return serviceList=serviceDao.fetchTodaysServiceList();
		
	}

}
