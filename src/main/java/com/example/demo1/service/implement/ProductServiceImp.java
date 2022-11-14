package com.example.demo1.service.implement;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo1.entity.Category;
import com.example.demo1.entity.Product;
import com.example.demo1.repository.ProductRepository;
import com.example.demo1.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	private ProductRepository repo;
	
	@Override
	public List<Product> listAll() {
		return repo.findAll();
	}
	
	@Override
	public void save(Product product) {
		repo.save(product);
	}
	
	@Override
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public void saveProductToDB(Long id, String name, String brand, String madeIn, Float price, MultipartFile file, Category category) {
		Product p = new Product();
		p.setId(id);
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("Invalid file");
		}
		try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p.setName(name);
		p.setBrand(brand);
		p.setMadein(madeIn);
		p.setPrice(price);
		p.setCategory(category);
		
		repo.save(p);
	}
}