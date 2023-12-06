package com.jspiders.cardekho_casestudy_hibernate.main;

import java.util.Scanner;

import com.jspiders.cardekho_casestudy_hibernate.dao.CarOperation;

public class CarDekhoMenu {
	private static CarOperation operation=new CarOperation();
	private static boolean loop=true;
	public static void main(String[] args) {
		while (loop) {
			carDekhoMenu();
		}
	}
	private static void carDekhoMenu() {
		System.out.println("=============MENU===========\n"
				+"1. Add/Remove Car Details \n"
				+"2. Search Car Details \n"
				+"3. Edit Car details \n"
				+"4. Exit");
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter your choice : ");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("=============MENU===========\n"
					+"1. Add Car Details \n"
					+"2. Remove Car Details \n"
					+"3. Go Back To Main Menu");
			System.out.print("Enter Your Choice : ");
			int choice2=scanner.nextInt();
			switch (choice2) {
			case 1:
				operation.addCarDetails();
				break;
			case 2:
				operation.removeCarDetails();
				break;
			case 3:
				carDekhoMenu();
				break;

			default:
				System.out.println("\n Invalid Choice. Try again");
				break;
			}
			break;

		case 2:
			System.out.println("===========MENU==========\n"
								+ "1. Search Car By Name \n"
								+ "2. Search Car By Brand \n"
								+ "3. Search Car By Fuel Type \n"
								+ "4. Search All Cars \n"
								+ "5. Go Back To Main Menu");
			int choice3 = scanner.nextInt();
			switch(choice3) {
			case 1:
				operation.searchByName();
				break;
			case 2:
				operation.searchByBrand();
				break;
			case 3:
				operation.searchByFuelType();
				break;
			case 4:
				operation.getAllCarDetails();
				break;
			case 5:
				carDekhoMenu();
				break;
			default:
				System.out.println("\nInvalid choice. Try again..!!");
				break;
			}
			break;
		case 3:
			operation.editCarDetails();
			break;
		case 4:
			System.out.println("Thank you..!!");
			loop = false;
			scanner.close();
			break;

		default:
			System.out.println("\nInvalid choice. Try again..!!");
			break;

		}
		
	}
	

}