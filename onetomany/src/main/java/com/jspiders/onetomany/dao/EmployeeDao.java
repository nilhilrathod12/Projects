package com.jspiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.Company;
import com.jspiders.onetomany.dto.Employee;

public class EmployeeDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
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
		Company company=new Company();
		company.setId(1);
		company.setName("infosys");
		company.setEmail("infosys@gmail.com");
		company.setAddress("pune");
		
		Employee employee1=new Employee();
		employee1.setId(1);
		employee1.setName("ramesh");
		employee1.setEmail("ramesh@gmail.com");
		employee1.setSalary(34000.00);
		
		Employee employee2=new Employee();
		employee2.setId(2);
		employee2.setName("suresh");
		employee2.setEmail("suresh@gmail.com");
		employee2.setSalary(34000.00);
		
		Employee employee3=new Employee();
		employee3.setId(3);
		employee3.setName("ganesh");
		employee3.setEmail("ganesh@gmail.com");
		employee3.setSalary(34000.00);
		
		List<Employee> employees=new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		
		company.setEmployees(employees);
		
		entityManager.persist(company);
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityTransaction.commit();
		closeConnection();
	}

}
