package com.jspiders.studentmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.studentmvc.pojo.StudentPOJO;

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

	public StudentPOJO addStudent(String name, int marks) {
		openConnection();
		entityTransaction.begin();
		StudentPOJO pojo=new StudentPOJO();
		pojo.setName(name);
		pojo.setMarks(marks);
		entityManager.persist(pojo);
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	public List<StudentPOJO> searchStudent(int lowerMarks, int upperMarks) {
		openConnection();
		entityTransaction.begin();
		String jpql="from StudentPOJO where marks between "+lowerMarks+"and"+upperMarks+"";
		query=entityManager.createQuery(jpql);
		
		List<StudentPOJO> students=query.getResultList();
		
		
		entityTransaction.commit();
		closeConnection();
		return students;
	}


	

	
}
