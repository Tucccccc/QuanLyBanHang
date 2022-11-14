package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo1.entity.Category;
import com.example.demo1.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/add/category")
	public String addCategoryPage(Model model) {
		model.addAttribute("category", new Category());
		
		return "/test/categoriesAdd";
	}
	
	@PostMapping("/save/saveCategory")
	public String saveCategory(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		
		return "redirect:/";
	}
}