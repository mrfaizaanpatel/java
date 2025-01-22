package com.learn.Ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Table(name = "product_details") will help to change Table name
//@Table(name="table_name")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Product {
	
	@Id
	private int productId;
	@Column(nullable = false)
	private String productName;
	@Column(name = "description",nullable = false)
	private String productDescription;
	@Column(nullable = false)
	private int productPrice;
	

}
