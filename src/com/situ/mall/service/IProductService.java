package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Product;

public interface IProductService {
	List<Product> findAll();

	boolean deletById(int id);

	Product findById(int id);

	boolean add(Product product);

	boolean update(Product product);

	List<Product> findCategoryListById(Integer id);
}
