package com.jspiders.springcoreannotations.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotations.beans.StudentBean2;
import com.jspiders.springcoreannotations.config.StudentConfig2;

public class StudentMain2 {
	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(StudentConfig2.class);
		StudentBean2 student2=(StudentBean2) context.getBean("student2");
		System.out.println(student2);
		((AnnotationConfigApplicationContext)context).close();
	}

}
