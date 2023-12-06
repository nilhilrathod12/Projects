package com.jspiders.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotations.beans.EmployeeBean;

public class EmployeeConfig {
	
	@Bean
	public EmployeeBean getEmployee() {
		return new EmployeeBean();
	}

}
