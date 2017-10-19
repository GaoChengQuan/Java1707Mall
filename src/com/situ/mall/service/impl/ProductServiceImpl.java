package com.situ.mall.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.constant.MallConstant;
import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IStaticPageService;

import sun.net.www.content.text.plain;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductDao productDao;
	@Autowired
	private IStaticPageService staticPageService;

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
				return ServerResponse.createError("添加商品失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加商品失败");
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

	@Override
	public ServerResponse show(Integer id) {
		if (id == null) {
			return ServerResponse.createError("id不能为空");
		}
		Product product = productDao.findById(id);
		if (null == product) {
			return ServerResponse.createError("该商品不存在");
		}
		
		Map root = new HashMap();
		root.put("product", product);
		
		//按照“，”分割subImages，
		String subImagesStr = product.getSubImages();
		if (null != subImagesStr && !subImagesStr.equals("")) {
			String[] subImages = subImagesStr.split(",");
			for (int i = 0; i < subImages.length; i++) {
				subImages[i] = MallConstant.SERVER_ADDRES + subImages[i];
			}
			root.put("subImages", subImages);
		}
		
		if (staticPageService.productIndex(root, product.getId())) {
			return ServerResponse.createSuccess("静态化页面成功");
		}
		return ServerResponse.createError("静态化页面失败");
	}

	
}
