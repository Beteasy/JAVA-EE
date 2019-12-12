package com.dao;

import java.util.List;

import com.entity.News;

public interface NewsDao {
//	public int insertNews(News news);
//	public int deleteNews(Integer id);
//	public int updateNews(News news);

	public News getNewsById(Integer id);
//	public List<News> getNewsByTitle(String title);
	public List<News> getAllNews();
}
