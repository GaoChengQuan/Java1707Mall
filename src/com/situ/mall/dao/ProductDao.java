package com.situ.mall.dao;

import java.util.List;

import com.situ.mall.pojo.Product;

public interface ProductDao {
	List<Product> findAll();

	int deletById(int id);

	Product findById(int id);

	int add(Product product);

	int update(Product product);
}
