package com.jspiders.multithreading.resource;

public class Pizza {
	private int availablePizza;

	public synchronized void orderPizza(int orderdPizza) {
		System.out.println("Trying to order " + orderdPizza + " Pizzas");
		if (availablePizza < orderdPizza) {
			System.out.println(orderdPizza + " pizzas not available please wait......!!");
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		availablePizza -=orderdPizza;
		System.out.println(orderdPizza+" pizzas delivered");
		System.out.println(availablePizza+" pizzas available");
	}
	public synchronized void bakedPizza(int bakedPizza) {
		System.out.println("baking "+bakedPizza+" Pizzas");
		availablePizza +=bakedPizza;
		System.out.println(bakedPizza+" pizzas baked");
		System.out.println(availablePizza+" pizzas available");
		this.notify();
	}
	

}
