package com.jspiders.multithreading.thread;

public class MyThread3 extends Thread {
	@Override
	public void run() {
		System.out.println("Name of Thread: "+getName());
		System.out.println("Priority of Thread: "+getPriority());
	}

}
