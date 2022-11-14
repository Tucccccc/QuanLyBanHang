package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo1.entity.Product;
import com.example.demo1.global.GlobalData;
import com.example.demo1.service.ProductService;

@Controller
public class CartController {
	@Autowired
	private ProductService productSerice;
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable Long id) {
		GlobalData.cart.add(productSerice.get(id));
		
		return "redirect:/";
	}
	
	@GetMapping("/cart")
	public String cartGet(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		
		return "test/cart";
	}
}
