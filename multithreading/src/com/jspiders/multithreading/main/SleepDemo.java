package com.jspiders.multithreading.main;

public class SleepDemo {
	public static void main(String[] args) {
		String msg="This is the sleep()";
		for (int i = 0; i < msg.length(); i++) {
			System.out.print (msg.charAt(i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
