package com.project.entity;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.project.dao.PartsDao;
import com.project.service.ServiceReqService;
import com.project.service.ServiceService;
import com.project.service.VehicleService;

public class Bill {
                private Customer customer;
                private CustomerVehicle customerVehicle;
                private ServiceRequest serviceRequest;
                private Map<PartsDao,Integer> partsList;
            
                
                public void prepareBill() {
                	try {
                		Scanner sc =new Scanner(System.in);
                		List<ServiceRequest> serviceRequestsList=ServiceService.fetchTodaysServiceList();
                		System.out.println("Enter service request id:");
                		int id=new Scanner(System.in).nextInt();
                		this.serviceRequest=serviceRequestsList.get(serviceRequestsList.indexOf(new ServiceRequest(id)));
                		if(this.serviceRequest!=null) {
                			ServiceService.serviceProvided(serviceRequest);
                			double bill=0;
                			for(Service service :serviceRequest.getServiceList() ) {
                				bill =bill + service.getTotal_cost();
                			}
                			System.out.println(bill);
                			this.serviceRequest.setBill_amount(bill);
                			ServiceReqService.addBill(bill,this.serviceRequest.getId(),serviceRequest);
                			fetchAllData();
                		}else {
                			System.out.println("Service does not exists....");
                		}
                	}
                	
                	private void fetchAllData() {
                		this.customerVehicle=VehicleService.getSpecificVehicles(this.serviceRequest.getVehicle_number());
                		
                		
                	}
                	
                	catch(Exception e) {
                		e.printStackTrace();
                	}
                }
}
