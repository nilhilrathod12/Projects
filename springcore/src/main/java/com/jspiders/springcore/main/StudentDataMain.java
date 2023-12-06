package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.StudentDataBean;

public class StudentDataMain {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("StudentDataCourseConfig.xml");
        StudentDataBean student1 = (StudentDataBean) context.getBean("student1");
        System.out.println(student1);
        
        StudentDataBean student2 = (StudentDataBean) context.getBean("student2");
        System.out.println(student2);
        
        ((ClassPathXmlApplicationContext)context).close();
	}	

}
