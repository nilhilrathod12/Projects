package com.jspiders.springcore.bean;

import lombok.Data;

@Data
public class VoterBean {
	int id;
	String name;
	String address;
	
	VotingCardBean votingCard;

}
