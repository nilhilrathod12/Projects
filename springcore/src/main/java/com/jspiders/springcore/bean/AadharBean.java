package com.jspiders.springcore.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AadharBean {
	int id;
	long aadharNo;
	@Override
	public String toString() {
		return "AadharBean [id=" + id + ", aadharNo=" + aadharNo + "]";
	}
	
	

}
