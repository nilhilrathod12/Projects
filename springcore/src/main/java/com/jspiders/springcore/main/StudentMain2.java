package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.StudentBean;

public class StudentMain2 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("StudentConfig2.xml");
		StudentBean student1=(StudentBean) context.getBean("student1");
		System.out.println(student1);
		
		StudentBean student2=(StudentBean) context.getBean("student2");
		System.out.println(student2);
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
