package by.it.academy.dao;

import by.it.academy.model.News;

import java.util.List;


public interface DAO {

	News getNews(int id);

	int addNews(News news);

	int deleteNews(int id);

	int editNews(News news);

	List<News> getAllNews();

	List<News> getNewsByCategoryId(String category);

}
