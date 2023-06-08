package com.project.main;

import java.util.Scanner;


enum EmainMenu{
	EXIT,CUSTOMER,VEHICLE,SERVICE,PARTS,TODAYS_BUSINESS,GIVEN_DATE_BUSINESS
}

public class MainMenu {

	
	public static EmainMenu mainMenuOptions() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Vehicle");
		System.out.println("3.Service");
		System.out.println("4.parts");
		System.out.println("5.Today's Business");
		System.out.println("6.Given Date's Business");
		System.out.println("Enter your Choice: ");
		int choice =new Scanner(System.in).nextInt();
		return EmainMenu.values()[choice];
	}
	public static void main(String[] args) {
		EmainMenu choice;
		while((choice=mainMenuOptions())!=EmainMenu.EXIT) {
			switch (choice) {
			case CUSTOMER:
				SubMenu.customerMain();
				break;
			case VEHICLE:
				SubMenu.vehicleMain();
				break;
			case SERVICE:
				SubMenu.serviceMain();
				break;
			case PARTS:
				SubMenu.partsMain();
				break;
			case TODAYS_BUSINESS:
				SubMenu.todaysBusinessMain();
				break;
			case GIVEN_DATE_BUSINESS:
				SubMenu.givenDateBusinessMain();
				break;
				
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}
	

}
