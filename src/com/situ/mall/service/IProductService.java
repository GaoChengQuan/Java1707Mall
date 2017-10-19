package com.situ.mall.service;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.pojo.Product;

public interface IProductService {
	List<Product> findAll();
	
	ServerResponse<List<Product>> findAllJson();

	boolean deletById(int id);

	Product findById(int id);

	ServerResponse add(Product product);

	boolean update(Product product);

	List<Product> findCategoryListById(Integer id);

	ServerResponse show(Integer id);
}
