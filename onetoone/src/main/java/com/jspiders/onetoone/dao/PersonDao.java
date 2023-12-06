package com.jspiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.dto.AdharCard;
import com.jspiders.onetoone.dto.Person;

public class PersonDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("person");
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
		Person person=new Person();
		person.setId(1);
		person.setName("Ramesh");
		person.setEmail("rahul@gmail.com");
		person.setDateOfBirth("02/01/2002");
		
		AdharCard adharCard=new AdharCard();
		adharCard.setId(1);
		adharCard.setAdharNumber(004500340033);
		adharCard.setDateOfIssue("12/03/2018");
		
		person.setAdharCard(adharCard);
		entityManager.persist(adharCard);
		entityManager.persist(person);
		entityTransaction.commit();
		closeConnection();
	}

}
