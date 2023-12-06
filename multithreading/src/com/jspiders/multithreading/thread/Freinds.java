package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Pizza;

public class Freinds extends Thread {
	private Pizza pizza;

	public Freinds(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void run() {
		pizza.orderPizza(5);
	}

}
