package com.jspiders.cardekhomvc.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhomvc.pojo.AdminPOJO;
import com.jspiders.cardekhomvc.pojo.CarPOJO;

@Repository
public class AdminRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	public void openConnection() {
		factory=Persistence.createEntityManagerFactory("cardekho");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	public void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public AdminPOJO createAccount(String name, String email, String username, String password) {
		openConnection();
		transaction.begin();
		AdminPOJO pojo=new AdminPOJO();
		pojo.setName(username);
		pojo.setEmail(email);
		pojo.setUsername(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public AdminPOJO loginAccount(String username, String password) {
		openConnection();
		transaction.begin();
		String jpql="from AdminPOJO where username = '"+username+"'"+"and password = '"+password+"'";
		query=manager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List <AdminPOJO> admins = query.getResultList();
		for(AdminPOJO admin:admins) {
			transaction.commit();
			closeConnection();
			return admin;
		}
		
		return null;
	}
		
}
