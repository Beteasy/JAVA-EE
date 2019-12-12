package com.service;

import java.util.List;

import com.dao.impl.ProductTypeDaoImpl;
import com.entity.ProductType;

public class ProductService {
	ProductTypeDaoImpl productTypeDaoImpl = new ProductTypeDaoImpl();
	
	public ProductType getProductTypeById(Integer id) {
		ProductType productType = null;
		productType = productTypeDaoImpl.getProductTypeById(id);
		return productType;
	}
	
	public List<ProductType> getAllProductType(){
		List<ProductType> productTypeList = null;
		productTypeList = productTypeDaoImpl.getAllProductType();
		return productTypeList;
	}
}
