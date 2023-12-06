package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Pizza;
import com.jspiders.multithreading.thread.Dominos;
import com.jspiders.multithreading.thread.Freinds;

public class PizzaMain {
	public static void main(String[] args) {
		Pizza pizza=new Pizza();
		
		Freinds freinds=new Freinds(pizza);
		Dominos dominos=new Dominos(pizza);
		
		freinds.start();
		dominos.start();
	}
	
     

}
