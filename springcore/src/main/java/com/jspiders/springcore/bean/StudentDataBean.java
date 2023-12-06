package com.jspiders.springcore.bean;

import java.util.List;

import lombok.Data;

@Data
public class StudentDataBean {
	int id;
	String name;
	String email;
	
	List<CourseBean> courses;

}
