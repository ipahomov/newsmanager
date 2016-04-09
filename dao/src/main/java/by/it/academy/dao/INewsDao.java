package by.it.academy.dao;

import by.it.academy.model.News;

import java.util.List;

/**
 * interface for operations with news
 */
public interface INewsDao {

	/**
	 * Get news by id
	 * @param id
	 * @return news
     */
	News getNews(int id);

	/**
	 * Add new news method
	 * @param news - parameter to addNews method, type News
	 * @return int - return affected rows after adding new news
     */
	int addNews(News news);

	int deleteNews(int id);

	int editNews(News news);

	List<News> getAllNews();

	List<News> getNewsByCategoryId(String category);

}
