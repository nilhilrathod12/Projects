package com.jspiders.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrest.pojo.StudentPOJO;
import com.jspiders.springrest.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public StudentPOJO addStudent(StudentPOJO pojo) {
		StudentPOJO student = repository.addStudent(pojo);
		return student;
	}

	public StudentPOJO searchStudent(int id) {
		StudentPOJO pojo = repository.searchStudent(id);
		return pojo;
	}

	public List<StudentPOJO> searchAllStudent() {
		List<StudentPOJO> students = repository.searchAllStudent();
		return students;
	}

	public StudentPOJO deleteStudent(int id) {
		StudentPOJO pojo = repository.deleteStudent(id);
		return pojo;
	}

	public StudentPOJO updateStudent(StudentPOJO pojo) {
		StudentPOJO student=repository.updateStudent(pojo);
		return student;
	}

}
