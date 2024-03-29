package com.project.main;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.dao.CustomerDao;
import com.project.entity.Bill;
import com.project.entity.Customer;
import com.project.entity.ServiceRequest;
import com.project.entity.SpecificCustomerVehicles;
import com.project.service.CustomerService;
import com.project.service.PartsService;
import com.project.service.ServiceReqService;
import com.project.service.ServiceService;
import com.project.service.VehicleService;

enum ECustomerMenu {
	BACK, ADD_CUSTOMER, DISPLAY_ALL_CUSTOMER, DISPLAY_SPECIFIC_CUSTOMER, EDIT_CUSTOMER, DELETE_CUSTOMER, DEFAULT
}

enum EVehicleMenu {
	BACK, ADD_VEHICLE, DISPLAY_ALL_VEHICLE, DISPLAY_SPECIFIC_VEHICLE, EDIT_VEHICLE, DELETE_VEHICLE, DEFAULT
}

enum EServiceMenu {
	BACK, SELECT_CUSTOMER_VEHICLE, PROCESS_REQUEST, PREPARE_AND_DISPLAY_BILL, GET_PAYMENT_FORM_CUSTOMER, DEFAULT
}

enum EProcessRequestMenu {
	BACK, NEW_SERVICE, EXISTING_SERVICE, MAINTENANCE, REPAIRING, OIL_ADDITIVE_CHANGE, DEFAULT
}

enum ENewService {
	BACK, CREATE_NEW_SERVICE, DEFAULT
}

enum EExistingService {
	BACK, SELECT_EXISTING_SERVICE, DEFAULT
}

enum EMaintenanceRequirement {
	BACK, MAINTENANCE_REQUIREMENT, DEFAULT
}

enum ERepairingRequirement {
	BACK, REPAIRING_REQUIREMENT, DEFAULT
}

enum EOilAddRequirement {
	BACK, OIL_ADD, DEFAULT
}

enum EPartsMenu {
	BACK, ADD_PART, DISPLAY_ALL_PARTS, EDIT_PART_PRICE, DELETE_PART, DEFAULT
}

public class SubMenu {

	public static ECustomerMenu customerMenu() {
		System.out.println("0.Back");
		System.out.println("1.Add Customer");
		System.out.println("2.Display All Customer");
		System.out.println("3.Display Specific Customer Details");
		System.out.println("4.Edit Customer");
		System.out.println("5.Delete Customer");
		System.out.println("Enter Choice: ");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 5)
			return ECustomerMenu.values()[6];
		else
			return ECustomerMenu.values()[choice];
	}

	public static void customerMain() {
		ECustomerMenu choice;
		while ((choice = customerMenu()) != ECustomerMenu.BACK) {
			switch (choice) {
			case ADD_CUSTOMER:
				CustomerService.addCustomer();

				break;
			case DISPLAY_ALL_CUSTOMER:
				CustomerService.getAllCustomer();

				break;
			case DISPLAY_SPECIFIC_CUSTOMER:
				System.out.println(CustomerService.getSpecificCustomer());
				break;
			case EDIT_CUSTOMER:
				CustomerService.updateCustomer();
				break;
			case DELETE_CUSTOMER:
				CustomerService.deleteCustomer();
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static EVehicleMenu vehicleMenu() {
		System.out.println("0.Back");
		System.out.println("1.Add Vehicle");
		System.out.println("2.Display All Vehicle");
		System.out.println("3.Display Specific Vehicle Details");
		System.out.println("4.Edit Vehicle");
		System.out.println("5.Delete Vehicle");
		System.out.println("Enter Choice: ");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 5)
			return EVehicleMenu.values()[6];
		else
			return EVehicleMenu.values()[choice];
	}

	public static void vehicleMain() {
		EVehicleMenu choice;
		while ((choice = vehicleMenu()) != EVehicleMenu.BACK) {
			switch (choice) {
			case ADD_VEHICLE:
				VehicleService.addVehicle();
				break;
			case DISPLAY_ALL_VEHICLE:
				VehicleService.getAllVehicle();
				break;
			case DISPLAY_SPECIFIC_VEHICLE:
				Customer cust = CustomerService.getSpecificCustomer();
				VehicleService.getSpecificVehicles(cust);
				break;
			case EDIT_VEHICLE:
				VehicleService.updateVehicle();
				break;
			case DELETE_VEHICLE:
				VehicleService.deleteVehicle();
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static EServiceMenu serviceMenu() {
		System.out.println("0.Back");
		System.out.println("1.Select Customer Vehicle");
		System.out.println("2.Process Request");
		System.out.println("3.Prepare and Display Bill");
		System.out.println("4.Get Payment Form Customer");
		System.out.println("Enter Choice: ");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 4)
			return EServiceMenu.values()[5];
		else
			return EServiceMenu.values()[choice];
	}

	public static void serviceMain() {
		EServiceMenu choice;
		String vehicle_number = null;
		while ((choice = serviceMenu()) != EServiceMenu.BACK) {
			switch (choice) {
			case SELECT_CUSTOMER_VEHICLE:
				vehicle_number = ServiceReqService.selectCustomerVehilcle();
				break;
			case PROCESS_REQUEST:
				if (vehicle_number != null)
					processRequestMain(vehicle_number);
				else
					System.out.println("First select the vehicle!!");
				break;
			case PREPARE_AND_DISPLAY_BILL:
				Bill bill=new Bill();
				bill.prepareBill();
				break;
			case GET_PAYMENT_FORM_CUSTOMER:
				System.out.println("Get Payment Form Customer");
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static EProcessRequestMenu processRequestMenu() {
		System.out.println("0.Back");
		System.out.println("1.New Services");
		System.out.println("2.Existing Service ");
		System.out.println("3.Maintenance");
		System.out.println("4.Repairing");
		System.out.println("5.Oil/Additive Change/Add ");
		System.out.println("Enter Choice: ");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 5)
			return EProcessRequestMenu.values()[6];
		else
			return EProcessRequestMenu.values()[choice];
	}

	public static void processRequestMain(String vehicleNumber) {
		EProcessRequestMenu choice;
		ServiceRequest serviceRequest = null;
		while ((choice = processRequestMenu()) != EProcessRequestMenu.BACK) {
			switch (choice) {
			case NEW_SERVICE:
				try {
					serviceRequest = ServiceService.newService(vehicleNumber);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case EXISTING_SERVICE:
				
				try {
					List<ServiceRequest> list=ServiceService.fetchTodaysServiceList();
					System.out.println("Enter id to Service=> ");
					int id = new Scanner(System.in).nextInt();
					serviceRequest=list.get(list.indexOf(new ServiceRequest(id)));
					System.out.println(serviceRequest);
					ServiceService.serviceProvided(serviceRequest); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case MAINTENANCE:
			    if(serviceRequest!=null)
			    {
			    	try {
						ServiceService.doMaintainance(serviceRequest);
					} catch (Exception e) {
						e.printStackTrace();
					}
			    }
			    else {
			    	System.out.println("First select service");
			    }
				break;
			case REPAIRING:
				 if(serviceRequest!=null)
				    {
				    	try {
							ServiceService.doRepairing(serviceRequest);
						} catch (Exception e) {
							e.printStackTrace();
						}
				    }
					break;
			case OIL_ADDITIVE_CHANGE:
				 if(serviceRequest!=null)
				    {
				    	try {
							ServiceService.addOil(serviceRequest);
						} catch (Exception e) {
							e.printStackTrace();
						}
				    }
				    else {
				    	System.out.println("First select service");
				    }
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static ENewService newServiceMenu() {
		System.out.println("0.BACK");
		System.out.println("1.Creating new Servicess");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 1)
			return ENewService.values()[2];
		else
			return ENewService.values()[choice];
	}

	public static EExistingService existingServiceMenu() {
		System.out.println("0.BACK");
		System.out.println("1.Select Existing Service");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 1)
			return EExistingService.values()[2];
		else
			return EExistingService.values()[choice];
	}

	public static void existingServiceMain() {
		EExistingService choice;
		while ((choice = existingServiceMenu()) != EExistingService.BACK) {
			switch (choice) {
			case SELECT_EXISTING_SERVICE:
				System.out.println("Existing Service");
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static EMaintenanceRequirement maintenanceRequirementMenu() {

		System.out.println("0.BACK");
		System.out.println("1.maintenance required");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 1)
			return EMaintenanceRequirement.values()[2];
		else
			return EMaintenanceRequirement.values()[choice];
	}

	public static void maintenanceRequirementMain() {

		EMaintenanceRequirement choice;
		while ((choice = maintenanceRequirementMenu()) != EMaintenanceRequirement.BACK) {

			switch (choice) {
			case MAINTENANCE_REQUIREMENT:
				System.out.println("maintenance required");
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static ERepairingRequirement repairingRequirementMenu() {
		System.out.println("0.BACK");
		System.out.println("1.Repairing Requirement	");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 1)
			return ERepairingRequirement.values()[2];
		else
			return ERepairingRequirement.values()[choice];
	}

	public static void repairingRequirementMain() {
		ERepairingRequirement choice;
		while ((choice = repairingRequirementMenu()) != ERepairingRequirement.BACK) {
			switch (choice) {
			case REPAIRING_REQUIREMENT:
				System.out.println("Repairing Requirement");
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static EOilAddRequirement oilAddRquirementMenu() {
		System.out.println("0.BACK");
		System.out.println("1.Repairing Requirement	");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 1)
			return EOilAddRequirement.values()[2];
		else
			return EOilAddRequirement.values()[choice];
	}

	public static void oilAddRquirementMain() {
		EOilAddRequirement choice;
		while ((choice = oilAddRquirementMenu()) != EOilAddRequirement.BACK) {
			switch (choice) {
			case OIL_ADD:
				System.out.println("Oil/Additive Change/Add Requirement");
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static EPartsMenu partsMenu() {
		System.out.println("0.Back");
		System.out.println("1.Add Part");
		System.out.println("2.Display All Parts");
		System.out.println("3.Edit Part Price");
		System.out.println("4.Delete Part ");
		System.out.println("Enter Choice: ");
		int choice = new Scanner(System.in).nextInt();
		if (choice < 0 || choice > 4)
			return EPartsMenu.values()[5];
		else
			return EPartsMenu.values()[choice];
	}

	public static void partsMain() {
		EPartsMenu choice;
		while ((choice = partsMenu()) != EPartsMenu.BACK) {
			switch (choice) {
			case ADD_PART:
				PartsService.addParts();
				break;
			case DISPLAY_ALL_PARTS:
				PartsService.getAllParts();
				break;
			case EDIT_PART_PRICE:
				PartsService.updateParts();
				break;
			case DELETE_PART:
				PartsService.deleteParts();
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public static void todaysBusinessMain() {
		System.out.println("Today's Business");

	}

	public static void givenDateBusinessMain() {
		System.out.println("given Date Business");

	}

}
