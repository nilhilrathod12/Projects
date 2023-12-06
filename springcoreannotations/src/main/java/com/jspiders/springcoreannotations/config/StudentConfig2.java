package com.jspiders.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotations.beans.StudentBean2;

public class StudentConfig2 {
	
	@Bean("student2")
	public StudentBean2 getStudent() {
		
		return new StudentBean2(2, "karan", "karan@gmail.com");
		
	}

}
