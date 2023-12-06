package com.jspiders.manytomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Course {
	@Id
	private int id;
	private String name;
	private double fees;

}
