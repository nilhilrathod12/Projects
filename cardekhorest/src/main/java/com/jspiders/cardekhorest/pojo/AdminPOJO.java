package com.jspiders.cardekhorest.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AdminPOJO {
    private String name;
    private String email;
    @Id
    private String username;
    private String password;
}
