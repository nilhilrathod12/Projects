package com.jspiders.designpattern.main;

import com.jspiders.designpattern.creational.Contact;
import com.jspiders.designpattern.creational.ContactBuilder;

public class ContactMain {
	public static void main(String[] args) {
		Contact contact=new ContactBuilder().lastName("rathod").firstName("nikhil").mobileNumber(75266961).getContact();
		System.out.println(contact);
	}

}
