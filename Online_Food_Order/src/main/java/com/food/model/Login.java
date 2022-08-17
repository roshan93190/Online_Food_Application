package com.food.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loginId;
	
	private String apiKey;
	
	private LoginStatus status;
	
	private Integer userId;
	
	private Integer cartId;
	
	private UserType userType;
	
}
