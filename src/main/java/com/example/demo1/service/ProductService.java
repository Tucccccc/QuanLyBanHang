package com.example.demo1.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo1.entity.Category;
import com.example.demo1.entity.Product;

public interface ProductService {

	void saveProductToDB(Long id, String name, String brand, String madeIn, Float price, MultipartFile file, Category category);

	void delete(Long id);

	Product get(Long id);

	void save(Product product);

	List<Product> listAll();
	
}