package com.example.demo1.global;

import java.util.ArrayList;
import java.util.List;

import com.example.demo1.entity.Product;

public class GlobalData {
	public static List<Product> cart;
	
	static {
		cart = new ArrayList<Product>();
	}
}