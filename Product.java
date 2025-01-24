package com.learn.Ecommerce.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.Order;
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
//	@ManyToOne
//	private Category category;
	
//	@ManyToMany(mappedBy = "products")
//	private List<Order> orders;
	private String productImage;
	

}
