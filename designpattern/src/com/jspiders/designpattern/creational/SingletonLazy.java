package com.jspiders.designpattern.creational;

public class SingletonLazy {
	private static SingletonLazy singletonLazy;

	public SingletonLazy() {
		System.out.println("constructor accessed");
	}

	public static SingletonLazy getObject() {
		if (singletonLazy == null) {
			singletonLazy=new SingletonLazy();
		}
		return singletonLazy;
	}

}
