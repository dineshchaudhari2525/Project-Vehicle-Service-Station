package com.project.service;

import java.sql.SQLException;

import com.project.dao.ServiceDao;
import com.project.dao.ServiceReqDao;
import com.project.entity.Service;

public class ServiceService {
	 public static Service  newService(String vehicle_number) throws SQLException {
			ServiceDao serviceDao;
			serviceDao=new ServiceDao();
			return serviceDao.addNewService(vehicle_number);
			
		}


}
