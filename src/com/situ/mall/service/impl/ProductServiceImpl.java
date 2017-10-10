package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public boolean deletById(int id) {
		return false;
	}

	@Override
	public Product findById(int id) {
		return productDao.findById(id);
	}

	@Override
	public boolean add(Product product) {
		int rowCount = productDao.add(product);
		return rowCount > 0 ? true : false;
	}

	@Override
	public boolean update(Product product) {
		return false;
	}

	@Override
	public List<Product> findCategoryListById(Integer id) {
		return productDao.findCategoryListById(id);
	}
	
}
