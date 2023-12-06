package com.jspiders.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotations.beans.StudentBean;

public class StudentConfig {
	
	
	@Bean
	public StudentBean getStudent() {
		StudentBean student1= new StudentBean();
		student1.setId(1);
		student1.setName("arjun");
		student1.setEmail("arjun@gmail.com");;
		return student1;
		
	}

}
