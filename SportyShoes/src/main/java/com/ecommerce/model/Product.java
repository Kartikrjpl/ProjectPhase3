package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//create table product (productId int, season varchar(20), brand varchar(20), category varchar(20),
//price float, color varchar(20), createdDate datetime not null,discount int, 
//primary key(productId));

@Entity
@Table(name = "product_sporty")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", updatable = false, nullable = false)
	private int id;
	@Column(name = "season")
	private String season;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "created_date")
	private String created_date;
	
	@Column(name = "discount")
	private int discount;
	
	public Product() {
		super();
	}
	public Product(int id, String season, String brand, String category, float price, String color, String created_date,
			int discount) {
		super();
		this.id = id;
		this.season = season;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.color = color;
		this.created_date = created_date;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getcreated_date() {
		return created_date;
	}

	public void setcreated_date(String created_date) {
		this.created_date = created_date;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	
}
