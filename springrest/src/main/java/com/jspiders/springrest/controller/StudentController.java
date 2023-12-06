package com.jspiders.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.StudentPOJO;
import com.jspiders.springrest.response.StudentResponce;
import com.jspiders.springrest.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping(path="/add",consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> addStudent(@RequestBody StudentPOJO pojo) {
		
		StudentPOJO student=service.addStudent(pojo);
		//success
		if (student != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data added successfully.", student, null), HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data added successfully.", student, null), HttpStatus.NOT_ACCEPTABLE) ;
		
	}
	
	@GetMapping(path = "search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> searchStudent(@PathVariable int id){
		StudentPOJO pojo=service.searchStudent(id);
		//success
		if (pojo != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data Found Successfully...", pojo, null),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data Not Fount...", pojo, null),HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping(path = "/searchAll",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudentResponce> searchAllStudent(){
		
		List<StudentPOJO> students=service.searchAllStudent();
		
		//Success
		if (students.isEmpty()==false) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data Found Successfully", null, students),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data Not Fount", null, null),HttpStatus.NOT_FOUND);
	   
   }
	
	@DeleteMapping(path = "delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StudentResponce> deleteStudent(@PathVariable int id){
		StudentPOJO pojo=service.deleteStudent(id);
		//Success
		if (pojo != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data Removed Successfully", pojo, null),HttpStatus.OK);
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data Not Removed", null, null),HttpStatus.BAD_REQUEST);
	  
  }
	@PutMapping(path = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponce> updateStudent(@RequestBody StudentPOJO pojo){
		StudentPOJO student=service.updateStudent(pojo);
		if (student != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data Updated Successfully..", student, null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data Not Updated..", null, null),HttpStatus.NOT_ACCEPTABLE);
		
	}

}
