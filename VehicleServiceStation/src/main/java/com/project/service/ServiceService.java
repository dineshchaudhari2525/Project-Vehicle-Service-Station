package com.project.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.project.dao.ServiceDao;
import com.project.dao.ServiceReqDao;
import com.project.entity.Maintainance;
import com.project.entity.Oil;
import com.project.entity.Service;
import com.project.entity.ServiceRequest;

public class ServiceService {
	public static ServiceRequest newService(String vehicle_number) throws SQLException {
		ServiceDao serviceDao;
		serviceDao = new ServiceDao();
		return serviceDao.addNewService(vehicle_number);

	}

	public static List<ServiceRequest> fetchTodaysServiceList() throws SQLException {
		ServiceDao serviceDao = new ServiceDao();
		List<ServiceRequest> serviceList = serviceDao.fetchTodaysServiceList();
		for (ServiceRequest slist : serviceList) {
			System.out.println(slist);
		}
		return serviceList;

	}

	public static List<Service> serviceProvided(ServiceRequest serviceRequest) throws SQLException {
		ServiceDao serviceDao = new ServiceDao();
		List<Service> serviceList = serviceDao.serviceProvided(serviceRequest);
		for (Service serProvided : serviceList) {
			System.out.println(serProvided);
		}
		return serviceList;
	}

	public static void doMaintainance(ServiceRequest serviceRequest) throws Exception {
		List<Service> serviceList = serviceRequest.getServiceList();
		Maintainance service = null;
		boolean serviceFound = false;

		if (serviceRequest.getServiceList().isEmpty()) {
			service = new Maintainance();
			service.acceptService();
			try (ServiceDao addServiceRequest = new ServiceDao()) {
				service.setService_request_id(serviceRequest.getId());
				serviceList.add(service);
				addServiceRequest.addService(service);

			} catch (Exception e) {
				e.printStackTrace();
			}
			serviceList.add(service);
		}

		else {
			for (int i = 0; i < serviceList.size(); i++) {
				Service s = serviceList.get(i);
				if (s instanceof Maintainance) {
					service = (Maintainance) s;
					service.acceptService();
					try (ServiceDao serv = new ServiceDao()) {

						serv.updateServices(service);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("add services");
				}
				{
					if (s instanceof Maintainance) {
						service = (Maintainance) s;
					}
				}
			}
		}

	}

	public static void addOil(ServiceRequest serviceRequest) throws Exception {
		List<Service>serviceList = serviceRequest.getServiceList();
		Oil service=null;
		if(serviceRequest.getServiceList().isEmpty()) {
			service=new Oil();
				service.acceptService();
				try(ServiceDao addServiceRequest=new ServiceDao()){
					service.setService_request_id(serviceRequest.getId());
					serviceList.add(service);
					addServiceRequest.addService(service);
				}catch(Exception e) {
					e.printStackTrace();
				}
				serviceList.add(service);
			}
			else {
				for(int i=0;i<serviceList.size();i++) {
					Service s=serviceList.get(i);
					if(s instanceof Oil) {
						service=(Oil)s;
						service.acceptService();
						try(ServiceDao serv=new ServiceDao()) {

							serv.updateServices(service);
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}else {
						System.out.println("add services");
					}
					
						if(s instanceof Oil) {
							service=(Oil)s;
						}
					
				}
			}
		
	}

}
