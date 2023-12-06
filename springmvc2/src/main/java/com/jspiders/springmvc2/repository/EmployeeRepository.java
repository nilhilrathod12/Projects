package com.jspiders.springmvc2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc2.pojo.EmployeePOJO;

@Repository
public class EmployeeRepository {
	
	public static EntityManagerFactory factory;
	public static EntityManager manager;
	public static EntityTransaction  transaction;
	public static Query query;
	
	public void openConnection() {
		factory=Persistence.createEntityManagerFactory("mvc");
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

	public EmployeePOJO addEmployee(String name, String email, long contact, double salary, String address) {
		openConnection();
		transaction.begin();
		EmployeePOJO pojo=new EmployeePOJO();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setSalary(salary);
		pojo.setAddress(address);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public List<EmployeePOJO> getEmployeeList() {
		openConnection();
		transaction.begin();
		String jpql="from EmployeePOJO";
		query=manager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<EmployeePOJO> employees=query.getResultList();
		transaction.commit();
		closeConnection();
		return employees;
	}

	public EmployeePOJO removeEmployee(int id) {
		openConnection();
		transaction.begin();
		EmployeePOJO pojo = manager.find(EmployeePOJO.class,id);
		
		manager.remove(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public EmployeePOJO searchEmployee(int id) {
		openConnection();
		transaction.begin();
		EmployeePOJO pojo=manager.find(EmployeePOJO.class, id);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public EmployeePOJO updateEmployeeData(int id, String name, String email, long contact, double salary, String address) {
		openConnection();
		transaction.begin();
		EmployeePOJO pojo=manager.find(EmployeePOJO.class, id);
		pojo.setId(id);
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setSalary(salary);
		pojo.setAddress(address);
		
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

}
