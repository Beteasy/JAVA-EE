package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.impl.NewsDaoImpl;
import com.entity.News;

public class NewsService {
	private NewsDaoImpl newsDaoImpl = new NewsDaoImpl();
	
	public News getNewsById(Integer id) {
		News news = null;
		news = newsDaoImpl.getNewsById(id);
		return news;
	}
	
//	public List<News> getUserByName(String name) {
//		List<News> news = new ArrayList<News>();
//		news = newsDaoImpl.getUserByName(name);
//		return news;
//	}
//	
	public List<News> getAllNews() {
		List<News> newsList = new ArrayList<News>();
		newsList = newsDaoImpl.getAllNews();
		return newsList;
	}
	
}
