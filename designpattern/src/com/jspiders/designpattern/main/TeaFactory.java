package com.jspiders.designpattern.main;

import java.util.Scanner;

import com.jspiders.designpattern.creational.Beverage;
import com.jspiders.designpattern.creational.BlackTea;
import com.jspiders.designpattern.creational.GreenTea;
import com.jspiders.designpattern.creational.IceTea;
import com.jspiders.designpattern.creational.NormalTea;

public class TeaFactory {
	public static Beverage beverage;
	public static void main(String[] args) {
		factory().order();
	}
	private static Beverage factory() {
		System.out.println("Select tea to order..");
		System.out.println("1.Normal tea\n"+"2.Black Tea\n"+"3.Green tea\n"+"Ice tea\n");
		Scanner scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		scanner.close();
		switch (choice) {
		case 1:
			beverage=new NormalTea();
			break;
		case 2:
			beverage=new BlackTea();
			break;
		case 3:
			beverage=new GreenTea();
			break;
		case 4:
			beverage=new IceTea();
			break;

		default:
			break;
		}
		return beverage;
	}

}
