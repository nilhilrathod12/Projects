package com.jspiders.springcoreannotations.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean2 {
	private int id;
	private String name;
	private String email;

}
