package com.project.main;

import java.util.Scanner;

public class Main {
	
	enum EmainMenu{
		EXIT,ADD,UPDATE,EMPLIST,DEPTLIST,DEFAULT
	}

	public class MainMenu {

		
		public static EmainMenu mainMenuOptions() {
			System.out.println("0.Exit");
			System.out.println("1. Add the new employee.");
			System.out.println("2.Update employee salary who belongs to Research department by 10%");
			System.out.println("3.List out all the employee and it's department name who joined in the particular year.");
			System.out.println("4.List out departments and departmentwise average salary along with number of employees working in corresponding department.");
			System.out.println("Enter your Choice: ");
			int choice =new Scanner(System.in).nextInt();
			if(choice < 0 || choice > 5)
				return EmainMenu.values()[5];
			else
				
				return EmainMenu.values()[choice];
			
		}
		public static void main(String[] args) {
			EmainMenu choice;
			while((choice=mainMenuOptions())!=EmainMenu.EXIT) {
				switch (choice) {
				case ADD:
					
					break;
				case UPDATE:
					
					break;
				case EMPLIST:
					
					break;
				case DEPTLIST:
					
					break;
					
				default:
					System.out.println("Wrong Choice");
					break;
				}
			}
		}
		

	}


}
