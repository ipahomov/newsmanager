package by.it.academy.services;

import by.it.academy.model.News;

import java.util.List;

/**
 * interface for news service
 */
public interface INewsService {

    /**
     * Add service for news
     *
     * @param news adding to list
     * @return int result of adding result (if > 0 - successfully)
     */
    int addNews(News news);

    /**
     * Delete service for news
     *
     * @param id of deleting news
     * @return int result of deleting result (if > 0 - successfully)
     */
    int deleteNews(int id);

    /**
     * Edit service for news
     *
     * @param news editing
     * @return int result of editing result ( >0 - successfully)
     */
    int editNews(News news);

    /**
     * Getting all news
     *
     * @return List Collection of all news
     */
    List<News> getAllNews();

    /**
     * Getting all news sorted by one common category
     *
     * @param category of news
     * @return List Collection of news sorted  by category
     */
    List<News> getNewsByCategoryId(String category);

    /**
     * Getting one news by id
     *
     * @param id of news which want to get
     * @return News one news
     */
    News getNews(int id);

}
