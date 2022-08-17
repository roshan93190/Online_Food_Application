package com.food.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.*;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	
	@NotNull(message = "item name should not be null")
	private String itemName;

	
	@NotNull(message = "quantity should not be null")
	private Integer quantity;
	
	@NotNull
	private Double itemPrice;
	

	
//	@OneToMany
//	private List<Restaurant> restList = new ArrayList<>();
	
	
}
