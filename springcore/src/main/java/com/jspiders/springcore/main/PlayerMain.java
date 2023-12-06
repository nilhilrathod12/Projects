package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.PlayersBean;

public class PlayerMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("PlayersTeam.xml");
		PlayersBean player1=(PlayersBean) context.getBean("player1");
		System.out.println(player1);
		
		PlayersBean player2=(PlayersBean) context.getBean("player2");
		System.out.println(player2);
		((ClassPathXmlApplicationContext) context).close();
	}

}
