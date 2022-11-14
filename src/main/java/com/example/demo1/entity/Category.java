package com.example.demo1.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long cateId;
	private String name;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> listProduct = new HashSet<>();
	
	public Category(Long cateId, String name, Set<Product> listProduct) {
		super();
		this.cateId = cateId;
		this.name = name;
		this.listProduct = listProduct;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(Set<Product> listProduct) {
		this.listProduct = listProduct;
	}
}