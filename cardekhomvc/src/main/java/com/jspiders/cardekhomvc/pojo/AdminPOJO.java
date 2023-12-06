package com.jspiders.cardekhomvc.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AdminPOJO {
     private String name;
     private String email;
     @Id
     private String username;
     private String password;
}
