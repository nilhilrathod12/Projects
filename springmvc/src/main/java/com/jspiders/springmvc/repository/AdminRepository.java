package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.StudentPOJO;

@Repository
public class AdminRepository {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;
	
	public void openConnection() {
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

	public AdminPOJO createAccount(String username, String password) {
		
		openConnection();
		entityTransaction.begin();
		
		AdminPOJO pojo=new AdminPOJO();
		pojo.setUsername(username);
		pojo.setPassword(password);
		
		entityManager.persist(pojo);
		entityTransaction.commit();
		closeConnection();
		
		return pojo;
	}

	public AdminPOJO loginAdmin(String username, String password) {
		openConnection();
		entityTransaction.begin();
		String jpql="from AdminPOJO where username = '"+username+"'"+"and password = '"+password+"'";
		query=entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List <AdminPOJO> admins = query.getResultList();
		for(AdminPOJO admin:admins) {
			entityTransaction.commit();
			closeConnection();
			return admin;
		}
		
		return null;
	}

	public StudentPOJO getAdmin() {
	      openConnection();
	      entityTransaction.begin();
	      String jpql="from StudentPOJO";
	      query=entityManager.createQuery(jpql);
	      List <StudentPOJO> students = query.getResultList();
	      if (students.isEmpty()==false) {
			for(StudentPOJO pojo:students) {
				entityTransaction.commit();
				closeConnection();
				return pojo;
			}
		}
	      entityTransaction.commit();
	      closeConnection();
		return null;
	}

}
