package com.jspiders.designpattern.main;

import com.jspiders.designpattern.creational.SingletonEager;

public class SingletonEagerMain {

	public static void main(String[] args) {
		SingletonEager singletonEager1 =SingletonEager.getOjbect();
		System.out.println(singletonEager1);

		SingletonEager singletonEager2 =SingletonEager.getOjbect();
		System.out.println(singletonEager2);

		SingletonEager singletonEager3 =SingletonEager.getOjbect();
		System.out.println(singletonEager3);
	}

}
