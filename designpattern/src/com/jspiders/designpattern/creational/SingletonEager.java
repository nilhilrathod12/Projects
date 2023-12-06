package com.jspiders.designpattern.creational;

public class SingletonEager {
	private static SingletonEager singletonEager=new SingletonEager();
	
	public static SingletonEager getOjbect() {
		return singletonEager;
	}

}
