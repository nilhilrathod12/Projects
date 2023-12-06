package com.jspiders.manytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Player {
	@Id
	private int id;
	private String name;
	private int jersyNumber;
	private int age;
	@ManyToOne
	private Team team;

}
