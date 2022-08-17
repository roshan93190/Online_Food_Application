package com.food.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rest_id;
	
	@NotNull
	private String rest_name;
	
	
	@JsonIgnoreProperties("restaurants")
	@ManyToOne(cascade = CascadeType.ALL)
	private Owner owner;

	
	@JsonIgnoreProperties("restaurant")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private Address rest_address;
	
	
	@JsonIgnoreProperties("restaurant")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private List<Item> item_list = new ArrayList<Item>();
	

}
