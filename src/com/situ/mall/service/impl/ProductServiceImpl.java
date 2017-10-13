package com.situ.mall.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
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
	public ServerResponse<List<Product>> findAllJson() {
		List<Product> list = productDao.findAll();
		if (list != null) {
			return ServerResponse.createSuccess("获取数据成功", list);
		} else {
			return ServerResponse.createError("获取数据失败");
		}
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
	public ServerResponse add(Product product) {
		try {
			int rowCount = productDao.add(product);
			if (rowCount > 0) {
				return ServerResponse.createSuccess("添加商品成功");
			} else {
				return ServerResponse.createSuccess("添加商品失败");
			}
		} catch (Exception e) {
			return ServerResponse.createSuccess("添加商品失败");
		}
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
