package com.qa.bakery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Bakery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Boolean isvegan;
	private String product;

	public Bakery() {
		super();
	}

	public Bakery(Integer id, String name, Boolean isvegan, String product) {
		super();
		this.id = id;
		this.name = name;
		this.isvegan = isvegan;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsvegan() {
		return isvegan;
	}

	public void setIsvegan(Boolean isvegan) {
		this.isvegan = isvegan;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}


}
