package com.jspiders.cardekho_case_study.main;

import java.util.Scanner;

import com.jspiders.cardekho_case_study.car_operations.CarOperations;

public class CarDekhoMenu {

	private static CarOperations operations = new CarOperations();

	public static boolean loop = true;

	public static void carDekhoMenu() {
		System.out.println("=============Menu===========");
		
		System.out.println("1. Add/remove Car Details");
		
		System.out.println("2. Search Car Detail");
		
		System.out.println("3. Edit Car Detail");
		
		System.out.println("4. Exit");

		System.out.println("Choose Option");
		
		Scanner sc = new Scanner(System.in);
		
		int opt = sc.nextInt();
		
		switch (opt) {
		case 1:
			System.out.println("1. Add car Details");
			
			System.out.println("2. Remove Car Details");
			
			System.out.println("3. Back to Main menu");

			System.out.println("Choose a Option: ");
			int opt2 = sc.nextInt();
			switch (opt2) {
			case 1:
				operations.addCarDetails();
				break;
			case 2:
				operations.removeCarDetails();
				break;
			case 3:
				carDekhoMenu();

				break;

			default:
				System.out.println("Envalid choise....Please Try Again!!!");
				break;
			}
			break;
		case 2:
			System.out.println("1. Search By Name");
			System.out.println("2. Search By Fuel Type");
			System.out.println("3. Search By Brand");
			System.out.println("4. Search By Price");
			System.out.println("Enter Your Option: ");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				operations.searchByName();
				break;
			case 2:
				operations.searchByFuel_type();
				break;
			case 3:
				operations.searchByBrand();
				break;
			case 4:
				operations.searchByPrice();
				break;

			default:
				System.out.println("Invalid Option Please select A Correct Option......");
				break;
			}
			break;

		case 3:
			operations.editCarDetails();
			;
			break;
		case 4:
			System.out.println("Thank You");
			loop = false;
			break;

		default:
			System.out.println("Envalid Option.....Please choose Correct Option!!!6");
			break;
		}
	}

	public static void main(String[] args) {
		while (loop) {
			carDekhoMenu();
		}

	}

}
