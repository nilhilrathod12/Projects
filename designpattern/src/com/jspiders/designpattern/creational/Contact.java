package com.jspiders.designpattern.creational;

public class Contact {
	private String address;
	private int age;
	private String dateOfBirth;
	private String email;
	private String firstName;
	private String gender;
	private long landlineNumber;
	private String lastName;
	private String middleName;
	private long mobileNumber;
	private String nickName;
	public Contact(String address, int age, String dateOfBirth, String email, String firstName, String gender,
			long landlineNumber, String lastName, String middleName, long mobileNumber, String nickName) {
		super();
		this.address = address;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.landlineNumber = landlineNumber;
		this.lastName = lastName;
		this.middleName = middleName;
		this.mobileNumber = mobileNumber;
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "Contact [address=" + address + ", age=" + age + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", firstName=" + firstName + ", gender=" + gender + ", landlineNumber=" + landlineNumber
				+ ", lastName=" + lastName + ", middleName=" + middleName + ", mobileNumber=" + mobileNumber
				+ ", nickName=" + nickName + "]";
	}

	

	

}
