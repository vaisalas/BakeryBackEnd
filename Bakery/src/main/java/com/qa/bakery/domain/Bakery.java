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
	private String dietary;
	private String product;

	public Bakery() {
		super();
	}

	public Bakery(Integer id, String name, String dietary, String product) {
		super();
		this.id = id;
		this.name = name;
		this.dietary = dietary;
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

	public String getDietary() {
		return dietary;
	}

	public void setDietary(String dietary) {
		this.dietary = dietary;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}



}
