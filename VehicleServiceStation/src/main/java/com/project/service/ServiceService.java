package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.dao.ServiceDao;
import com.project.dao.ServiceReqDao;
import com.project.entity.Maintainance;
import com.project.entity.Oil;
import com.project.entity.Parts;
import com.project.entity.Service;
import com.project.entity.ServiceParts;
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
		}

		else {
			for (int i = 0; i < serviceList.size(); i++) {
				Service s = serviceList.get(i);
				if (s instanceof Maintainance) {
					service = (Maintainance) s;
					service.acceptService();
					try (ServiceDao serv = new ServiceDao()) {
						System.out.println(service);
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
		List<Service> serviceList = serviceRequest.getServiceList();
		System.out.println(serviceList);
		Oil service = null;
		boolean serviceFound = false;   
		if (serviceRequest.getServiceList().isEmpty()) {
			service = new Oil();
			service.acceptService();
			try (ServiceDao addServiceRequest = new ServiceDao()) {
				service.setService_request_id(serviceRequest.getId());
				serviceList.add(service);
				addServiceRequest.addService(service);
			} catch (Exception e) {
				e.printStackTrace();
			}
			serviceList.add(service);
		} else {
			for (int i = 0; i < serviceList.size(); i++) {
				Service s = serviceList.get(i);
				if (s instanceof Oil) {
					service = (Oil) s;
					service.acceptService();
					try (ServiceDao serv = new ServiceDao()) {

						serv.updateServices(service);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("add services");
				}

				if (s instanceof Oil) {
					service = (Oil) s;
				}

			}
		}

	}

	public static void doRepairing(ServiceRequest serviceRequest) {
		List<Service> serviceList = serviceRequest.getServiceList();
		Maintainance service = null;
		boolean serviceFound = false;
		if (serviceList.isEmpty()) {
			service = new Maintainance();
			service.acceptService();
			try (ServiceDao serviceParts = new ServiceDao()) {
				service.setService_request_id(serviceRequest.getId());
				serviceList.add(service);
			
				partCost(service);
				serviceParts.addService(service);
				System.out.println(service);
			
				try(ServiceDao serviceDao = new ServiceDao();) {
					
					for (int j = 0; j < service.getPartsList().size(); j++) {
						service.getPartsList().get(j).setService_id(service.getId());
						serviceDao.doRepairing(service.getPartsList().get(j));

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			serviceList.add(service);
		} else {
			for (int i = 0; i < serviceList.size(); i++) {
				Service s = serviceList.get(i);
				if (s instanceof Maintainance) {
					service = (Maintainance) s;
					service.setPartsList(new ArrayList<>());
					partCost(service);
					try(ServiceDao serviceDao = new ServiceDao();) {
						
						for (int j = 0; j < service.getPartsList().size(); j++) {

							serviceDao.doRepairing(service.getPartsList().get(j));

						}
						serviceDao.updateServices(service);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}
	}

	public static void partCost(Service service) {
		if (service instanceof Maintainance) {

			List<ServiceParts> serviceParts = ((Maintainance) service).getPartsList();

			int choice = 0;
			while (choice == 0) {
				List<Parts> partsList = PartsService.getAllParts();
				System.out.println(partsList);
				System.out.println("Enter Part Id=> ");
				int part_id = new Scanner(System.in).nextInt();
				System.out.println("Enter Quantity=> ");
				int quantity = new Scanner(System.in).nextInt();
				Parts part = partsList.get(partsList.indexOf(new Parts(part_id)));
				System.out.println("To add More Parts Enter 0 Otherwise Enter 1");
				choice = new Scanner(System.in).nextInt();
				((Maintainance) service).setParts_cost(((Maintainance) service).getParts_cost() + part.getPrice()  * quantity);
				System.out.println(service);
				service.calculateTotalCost();
				ServiceParts sp = new ServiceParts(service.getId(), part_id, quantity);
				serviceParts.add(sp);
			}
		}

	}

}
