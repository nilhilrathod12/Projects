package com.jspiders.manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.Course;
import com.jspiders.manytomany.dto.Student;

public class StudentDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("students");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Student student1=new Student();
		student1.setId(1);
		student1.setName("darshan ");
		student1.setEmail("darshan@gmail.com");
		student1.setAddress("dange chowk");
		
		Student student2=new Student();
		student2.setId(2);
		student2.setName("tiru ");
		student2.setEmail("tiru@gmail.com");
		student2.setAddress("wakad");
		
		Student student3=new Student();
		student3.setId(3);
		student3.setName("nikhil ");
		student3.setEmail("nikhil@gmail.com");
		student3.setAddress("warje");
		
		Course course1=new Course();
		course1.setId(1);
		course1.setName("SQL");
		course1.setFees(10000.00);
		
		Course course2=new Course();
		course2.setId(2);
		course2.setName("Java");
		course2.setFees(15000.00);
		
		Course course3=new Course();
		course3.setId(3);
		course3.setName("Web-Tech");
		course3.setFees(15000.00);
		
		List<Course> courses1=new ArrayList<>();
		courses1.add(course1);
		
		List<Course> courses2=new ArrayList<>();
		courses2.add(course1);
		courses2.add(course2);
		
		List<Course> courses3=new ArrayList<>();
		courses3.add(course1);
		courses3.add(course2);
		courses3.add(course3);
		
		student1.setCourses(courses1);
		student2.setCourses(courses2);
		student3.setCourses(courses3);
		
		
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		
		
		
		entityTransaction.commit();
	    closeConnection();
	}

}
