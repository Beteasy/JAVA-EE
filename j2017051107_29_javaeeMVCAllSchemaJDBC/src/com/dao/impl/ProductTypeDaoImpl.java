package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtils.DBUtils;
import com.dao.ProductTypeDao;
import com.entity.ProductType;

public class ProductTypeDaoImpl implements ProductTypeDao {
	
//	三个接口对象
	Connection connection = null;
	PreparedStatement preparedstatement = null;
	ResultSet resultSet = null;
	


	@Override
	public ProductType getProductTypeById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from producttype where id = ?";
		ProductType productType = new ProductType();
		try {
//			step2:get connection
			connection = DBUtils.getConnection();
//			step3:get preparedstatement
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
//			step4:get resultSet
			resultSet = preparedstatement.executeQuery();
//			step5:deal with data
			while (resultSet.next()) {
				productType.setId(resultSet.getInt("id"));
				productType.setName(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productType;
	}

	@Override
	public List<ProductType> getAllProductType() {
		// TODO Auto-generated method stub
		ProductType productType = new ProductType();
		List<ProductType> productTypeList = new ArrayList<ProductType>();
		String sql = "select * from producttype";
		try {
//			step2:get connection
			connection = DBUtils.getConnection();
//			step3:get preparedstatement
			preparedstatement = connection.prepareStatement(sql);
//			step4:get resultSet
			resultSet = preparedstatement.executeQuery();
//			step5:deal with data
			while (resultSet.next()) {
				productType.setId(resultSet.getInt("id"));
				productType.setName(resultSet.getString("name"));
				productTypeList.add(productType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productTypeList;
	}

}
