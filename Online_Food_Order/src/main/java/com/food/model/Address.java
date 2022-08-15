package com.food.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer addressId;
	
	@NotNull(message = "building shoud not be null")
	private String buildingName;
	
	@NotNull(message = "street shoud not be null")
	private String streetNo;
	
	@NotNull(message = "area shoud not be null")
	private String area;
	
	@NotNull(message = "city shoud not be null")
	private String city;
	
	@NotNull(message = "state shoud not be null")
	private String state;
	
	@NotNull(message = "country shoud not be null")
	private String country;
	
	@NotNull
	@Size(min=6,max=6,message="Invalid Pincode")
	@Pattern(regexp="[0-9]{6}", message = "Only Valid for 6 digit indian pincode")
	private String pincode;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	@JsonIgnoreProperties("addresses")
	@JsonIgnore
	private User user;
	

}