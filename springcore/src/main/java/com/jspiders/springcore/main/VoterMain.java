package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.VoterBean;

public class VoterMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("VoterVotingCardConfig.xml");
		
		VoterBean voter1 = (VoterBean) context.getBean("voter1");
		
		System.out.println(voter1);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
