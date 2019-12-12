package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtils.DBUtils;
import com.dao.NewsDao;
import com.entity.News;


public class NewsDaoImpl implements NewsDao {
	

//	�����ӿڶ���
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;


	@Override
	public News getNewsById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from easybuy_news where id = ?";
		News news = null;
		try {
			
			connection = DBUtils.getConnection();
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
//			step4:ִ��sql���
			resultSet = preparedStatement.executeQuery();
//			step5:����resultSet
			if (resultSet.next()) {
				news = new News();
				news.setId(resultSet.getInt("id"));
				news.setTitle(resultSet.getString("title"));
				news.setContent(resultSet.getString("content"));
				news.setCreateTime(resultSet.getString("createTime"));
				System.out.println(news.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			step6:�ͷ���Դ
			DBUtils.releaseResource(connection,preparedStatement,resultSet);
		}
		return news;
	}


	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		String sql = "select * from easybuy_news";
		News news = null;
		List<News> newsList = new ArrayList<News>();
		
		try {
			
			connection = DBUtils.getConnection();
//			step3:����preparedStatement
			preparedStatement = connection.prepareStatement(sql);
//			step4:ִ��sql���
			resultSet = preparedStatement.executeQuery();
//			step5:����resultSet
			while (resultSet.next()) {
				news = new News();
				news.setId(resultSet.getInt("id"));
				news.setTitle(resultSet.getString("title"));
				news.setContent(resultSet.getString("content"));
				news.setCreateTime(resultSet.getString("createTime"));
				newsList.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			step6:�ͷ���Դ
			DBUtils.releaseResource(connection,preparedStatement,resultSet);
		}
		return newsList;
	}


}
