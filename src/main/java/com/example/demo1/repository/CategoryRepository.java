package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query(value = "SELECT * FROM category WHERE name = :cateName", nativeQuery = true)
	public Category getCategoryByName(String cateName);
}
