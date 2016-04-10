package by.it.academy.services;

import by.it.academy.model.News;

import java.util.List;

/**
 * interface for news service
 */
public interface INewsService {

    /**
     * Add service for news
     * @param news adding to list
     * @return int value of adding result ( >0 - successfully)
     */
    int addNews(News news);

    /**
     * Delete service for news
     * @param id of deleting news
     * @return int value of deleting result ( >0 - successfully)
     */
    int deleteNews(int id);

    /**
     * Edit service for news
     * @param news editing
     * @return int value of editing result ( >0 - successfully)
     */
    int editNews(News news);

    /**
     * Get all news
     * @return List Collection of news
     */
    List<News> getAllNews();

    /**
     * Get all news sorted by one category
     * @param category of news
     * @return List Collection of news
     */
    List<News> getNewsByCategoryId(String category);

    /**
     * Get one news by id
     * @param id of news
     * @return one news
     */
    News getNews(int id);

}
