package com.jspiders.multithreading.thread;

public class MyThread4 implements Runnable{

	@Override
	public void run() {
		System.out.println("Name of Thread: "+Thread.currentThread().getName());
		System.out.println("Priority of Thread: "+Thread.currentThread().getPriority());
		
	}

}
