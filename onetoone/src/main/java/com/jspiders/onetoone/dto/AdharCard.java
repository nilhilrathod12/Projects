package com.jspiders.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AdharCard {
	@Id
	private int id;
	private long adharNumber;
	private String dateOfIssue;

}
