package com.food.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer cartId;

	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itemList;

	private Double cartTotal = 00.0;
	
	@OneToOne
	private Customer customer;
}
