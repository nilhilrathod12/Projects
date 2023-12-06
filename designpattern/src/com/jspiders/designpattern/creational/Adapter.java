package com.jspiders.designpattern.creational;

public class Adapter extends Employee implements Event{

	@Override
	public void womensDay(Adapter adapter) {
		adapter.setId(1);
		adapter.setEmail("radha@gmail.com");
		adapter.setName("radha");
		System.out.println("Chief guest of womens day is  "+adapter.getName());
		
	}

	@Override
	public void mensDay(Adapter adapter) {
		adapter.setName("ramesh");
		adapter.setEmail("ramesh@gmail.com");
		adapter.setId(1);
		System.out.println("chief guest of mens day is   "+adapter.getName());
		
		
	}
	

}
