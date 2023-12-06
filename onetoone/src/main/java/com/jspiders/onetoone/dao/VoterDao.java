package com.jspiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.dto.Voter;
import com.jspiders.onetoone.dto.VotingCard;

public class VoterDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("voter");
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
		
		Voter voter1=new Voter();
		voter1.setId(1);
		voter1.setName("ramesh");
		voter1.setAddress("dange chowk");
		
		Voter voter2=new Voter();
		voter2.setId(2);
		voter2.setName("suresh");
		voter2.setAddress("wakad");
		
		VotingCard votingCard =new VotingCard();
		votingCard.setId(1);
		votingCard.setCardNumber("3456779");
		votingCard.setDateOfIssue("12/12/2022");
		
		VotingCard votingCard1 =new VotingCard();
		votingCard1.setId(2);
		votingCard1.setCardNumber("3456459");
		votingCard1.setDateOfIssue("11/1/2013");
		
		voter1.setVotingCard(votingCard);
		voter2.setVotingCard(votingCard1);
		
		
		entityManager.persist(votingCard1);
		entityManager.persist(votingCard);
		entityManager.persist(voter1);
		entityManager.persist(voter2);
		
		
		
		
		
		entityTransaction.commit();
		closeConnection();
	}

}
