package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo1.entity.Category;
import com.example.demo1.entity.Product;
import com.example.demo1.service.CategoryService;
import com.example.demo1.service.ProductService;

@Controller
public class AppController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = productService.listAll();
		model.addAttribute("listProducts", listProducts);

		return "test/index";
	}

	@PostMapping("/save/saveProduct")
	public String saveProduct(@RequestParam(name = "id", required = false) Long id,
			@RequestParam("name") String name,
			@RequestParam("brand") String brand,
			@RequestParam("madein") String madeIn,
			@RequestParam("price") Float price,
			@RequestParam("category") String categoryName,
			@RequestParam("imageFile") MultipartFile file
			) {

		Category category = new Category();
		category = categoryService.getCategoryByName(categoryName);
		
		productService.saveProductToDB(id, name, brand, madeIn, price, file, category);

		return "redirect:/";
	}

	@RequestMapping(value = "add/product")  
	public String addProductPage(Model model) {
		List<Category> listCategories = categoryService.findAll();
		model.addAttribute("listCategories", listCategories);
		
		model.addAttribute("product", new Product());  
		return "test/addTest";  
	}  
	
	@RequestMapping("/login")
	public String showLoginPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "/test/login";
		}
		
		return "redirect:/";
	}
}