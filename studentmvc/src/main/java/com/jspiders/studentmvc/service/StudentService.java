package com.jspiders.studentmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.studentmvc.pojo.StudentPOJO;
import com.jspiders.studentmvc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;

	public StudentPOJO addStudent(String name, int marks) {
		StudentPOJO pojo=repository.addStudent(name,marks);
		return pojo;
	}

	public List<StudentPOJO> searchStudent(int lowerMarks, int upperMarks) {
		List< StudentPOJO> students=repository.searchStudent(lowerMarks,upperMarks);
		return students;
	}

}
