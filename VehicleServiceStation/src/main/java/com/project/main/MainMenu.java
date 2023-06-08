package com.project.main;

import java.util.Scanner;

public class MainMenu {
	
	public static int mainMenuOptions() {
		System.out.println("0.Exit");
		System.out.println("1.Customer");
		System.out.println("2.Vehicle");
		System.out.println("3.Service");
		System.out.println("4.parts");
		System.out.println("5.Today's Business");
		System.out.println("6.Given Date's Business");
		System.out.println("Enter your Choice: ");
		return new Scanner(System.in).nextInt();
	}
	public static void main(String[] args) {
		int choice;
		while((choice=mainMenuOptions())!=0) {
			switch (choice) {
			case 1:
				SubMenu.customerMain();
				break;
			case 2:
				SubMenu.vehicleMain();
				break;
			case 3:
				SubMenu.serviceMain();
				break;
			case 4:
				SubMenu.partsMain();
				break;
			case 5:
				SubMenu.todaysBusinessMain();
				break;
			case 6:
				SubMenu.givenDateBusinessMain();
				break;
				
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}
	

}
