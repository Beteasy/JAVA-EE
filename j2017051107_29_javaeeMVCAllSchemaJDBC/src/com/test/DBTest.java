package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.dao.impl.ProductTypeDaoImpl;
import com.entity.ProductType;


public class DBTest {
	
	Logger log = Logger.getLogger("DBTest");

	@Test
	public void getProductTypeById() {
		ProductTypeDaoImpl productTypeDaoImpl = new ProductTypeDaoImpl();
		ProductType productType = productTypeDaoImpl.getProductTypeById(1);
		log.info(productType.toString());
	}
	
	@Test
	public void getAllProductType() {
		List<ProductType> productTypeList = new ArrayList<ProductType>();
		ProductTypeDaoImpl productTypeDaoImpl = new ProductTypeDaoImpl();
		productTypeList = productTypeDaoImpl.getAllProductType();
		log.info(productTypeList.toString());
	}
}
