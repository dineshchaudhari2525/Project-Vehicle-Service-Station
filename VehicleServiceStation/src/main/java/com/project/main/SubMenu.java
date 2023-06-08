package com.project.main;

import java.util.Scanner;

enum ECustomerMenu{
	BACK,ADD_CUSTOMER,DISPLAY_ALL_CUSTOMER,DISPLAY_SPECIFIC_CUSTOMER,EDIT_CUSTOMER,DELETE_CUSTOMER
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
		if(choice < 0 || choice >7)
			return ECustomerMenu.values()[7];
		else 
			return ECustomerMenu.values()[choice];
		}
	   public static void customerMain() {
		   ECustomerMenu choice;
		while((choice=customerMenu())!=ECustomerMenu.BACK) {
			switch (choice) {
			case ADD_CUSTOMER:
				System.out.println("1.Add Customer");
				break;
			case DISPLAY_ALL_CUSTOMER:
				System.out.println("2.Display All Customer");
				break;
			case DISPLAY_SPECIFIC_CUSTOMER:
				System.out.println("3.Display Specific Customer Details");
				break;
			case EDIT_CUSTOMER:
				System.out.println("4.Edit Customer");
				break;
			case DELETE_CUSTOMER:
				System.out.println("5.Delete Customer");
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}
	   public static int vehicleMenu() {
			System.out.println("0.Back");
			System.out.println("1.Add Vehicle");
			System.out.println("2.Display All Vehicle");
			System.out.println("3.Display Specific Vehicle Details");
			System.out.println("4.Edit Vehicle");
			System.out.println("5.Delete Vehicle");
			System.out.println("Enter Choice: ");
			return new Scanner(System.in).nextInt();
			}
		   public static void vehicleMain() {
			int choice;
			while((choice=vehicleMenu())!=0) {
				switch (choice) {
				case 1:
					System.out.println("Add Vehicle");
					break;
				case 2:
					System.out.println("Display All Vehicle");
					break;
				case 3:
					System.out.println("Display Specific Vehicle Details");
					break;
				case 4:
					System.out.println("Edit Vehicle");
					break;
				case 5:
					System.out.println("Delete Vehicle");
					break;

				default:
					System.out.println("Wrong Choice");
					break;
				}
			}
		}
		   
		   public static int serviceMenu() {
				System.out.println("0.Back");
				System.out.println("1.Select Customer Vehicle");
				System.out.println("2.Process Request");
				System.out.println("3.Prepare and Display Bill");
				System.out.println("4.Get Payment Form Customer");
				System.out.println("Enter Choice: ");
				return new Scanner(System.in).nextInt();
				}
			   public static void serviceMain() {
				int choice;
				while((choice=serviceMenu())!=0) {
					switch (choice) {
					case 1:
						System.out.println("Select Customer Vehicle");
						break;
					case 2:
						SubMenu.processRequestMain();
						break;
					case 3:
						System.out.println("Prepare and Display Bill");
						break;
					case 4:
						System.out.println("Get Payment Form Customer");
						break;

					default:
						System.out.println("Wrong Choice");
						break;
					}
				}
			}
			   
			   public static int processRequestMenu() {
					System.out.println("0.Back");
					System.out.println("1.New Services");
					System.out.println("2.Existing Service ");
					System.out.println("3.Maintenance");
					System.out.println("4.Repairing");
					System.out.println("5.Oil/Additive Change/Add ");
					System.out.println("Enter Choice: ");
					return new Scanner(System.in).nextInt();
					}
				   public static void processRequestMain() {
					int choice;
					while((choice=processRequestMenu())!=0) {
						switch (choice) {
						case 1:
							System.out.println("New Services");
							break;
						case 2:
							System.out.println("Existing Service");
							break;
						case 3:
							System.out.println("Maintenance");
							break;
						case 4:
							System.out.println("Repairing");
							break;
						case 5:
							System.out.println("Oil/Additive Change/Add");
							break;

						default:
							System.out.println("Wrong Choice");
							break;
						}
					}
				}
			   public static int partsMenu() {
					System.out.println("0.Back");
					System.out.println("1.Add Part");
					System.out.println("2.Display All Parts");
					System.out.println("3.Edit Part Price");
					System.out.println("4.Delete Part ");
					System.out.println("Enter Choice: ");
					return new Scanner(System.in).nextInt();
					}
				   public static void partsMain() {
					int choice;
					while((choice=partsMenu())!=0) {
						switch (choice) {
						case 1:
							System.out.println("Add Part");
							break;
						case 2:
							System.out.println("Display All Parts");
							break;
						case 3:
							System.out.println("Edit Part Price");
							break;
						case 4:
							System.out.println("Delete Part");
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
