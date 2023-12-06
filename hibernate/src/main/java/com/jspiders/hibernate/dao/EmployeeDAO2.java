package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("employee");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	public static void closeConnection() {
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
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
		EmployeeDTO dto=new EmployeeDTO();
		dto.setId(2);
		dto.setName("yuvraj singh");
		dto.setEmail("yuvi@gmail.com");
		dto.setAddress("wakad");
		dto.setContact(6666666666L);
		entityManager.persist(dto);
		
		EmployeeDTO dto2=new EmployeeDTO();
		dto2.setId(3);
		dto2.setName("rohit sharma");
		dto.setAddress("thergaon");
		dto2.setEmail("hitman@gmail.com");
		dto2.setContact(2642642642L);
		entityManager.persist(dto2);
		entityTransaction.commit();
		
	}

}
