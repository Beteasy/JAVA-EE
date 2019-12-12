package com.dao;

import java.util.List;

import com.entity.ProductType;

public interface ProductTypeDao {
	public ProductType getProductTypeById(Integer id);
//	public List<News> getNewsByTitle(String title);
	public List<ProductType> getAllProductType();
}
