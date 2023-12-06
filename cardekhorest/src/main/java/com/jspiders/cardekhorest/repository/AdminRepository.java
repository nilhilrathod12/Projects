package com.jspiders.cardekhorest.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhorest.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	public static EntityManagerFactory factory;
	public static EntityManager manager;
	public static EntityTransaction transaction;
	public static Query query;
	
	public void openConnection() {
		factory=Persistence.createEntityManagerFactory("cardekhorest");
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
	public AdminPOJO createAccount(AdminPOJO pojo) {
		openConnection();
		transaction.begin();
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		
		return pojo;
	}
	public AdminPOJO login(AdminPOJO pojo) {
		openConnection();
		transaction.begin();
		AdminPOJO admin=manager.find(AdminPOJO.class, pojo.getUsername());
		if (admin != null) {
			if (admin.getPassword().equals(pojo.getPassword())) {
				transaction.commit();
				closeConnection();
				return admin;
			}
		}
		transaction.commit();
		closeConnection();
		return null;
	}

}
