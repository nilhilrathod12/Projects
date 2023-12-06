package com.jspiders.cardekhorest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jspiders.cardekhorest.pojo.AdminPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(value = Include.NON_NULL)
public class AdminResponse {
      private String msg;
      private AdminPOJO pojo;
}
