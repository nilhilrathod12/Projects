package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.StudentPOJO;

@Repository
public class StudentRepository {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static Query query;
	
	public  void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("mvc");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		
	}
	
	public void closeConnection() {
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

	public StudentPOJO addStudent(String name, String email, long contact, String address) {
		openConnection();
		entityTransaction.begin();
		
		StudentPOJO pojo=new StudentPOJO();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setAddress(address);
		
		entityManager.persist(pojo);
		entityTransaction.commit();
		
		closeConnection();
		return pojo;
	}

	public StudentPOJO searchStudent(int id) {
		openConnection();
		entityTransaction.begin();
		StudentPOJO pojo=entityManager.find(StudentPOJO.class, id);
		entityTransaction.commit();
		closeConnection();
		
		return pojo;
	}

	public List<StudentPOJO> getStudentList() {
		
		openConnection();
		entityTransaction.begin();
		String jpql="from StudentPOJO";
		
		query=entityManager.createQuery(jpql);
		
		List<StudentPOJO> students=query.getResultList();
		entityTransaction.commit();
		closeConnection();
		return students;
	}

	public StudentPOJO removeStudent(int id) {
		openConnection();
		entityTransaction.begin();
		StudentPOJO pojo = entityManager.find(StudentPOJO.class, id);
		
		if (pojo != null) {
			entityManager.remove(pojo);
		}
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	public StudentPOJO updateStudentDetails(int id, String name, String email, long contact, String address) {
		openConnection();
		entityTransaction.begin();
		
		StudentPOJO pojo=entityManager.find(StudentPOJO.class, id);
		pojo.setId(id);
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setAddress(address);
		
		entityManager.persist(pojo);
		
		 entityTransaction.commit();
		 closeConnection();
		return pojo;
		
		
	}

}
