package by.it.academy.dao;

import by.it.academy.model.News;

import java.util.List;

/**
 * interface for operations with news
 */
public interface INewsDao {

    /**
     * This method getting one news from table by id
     *
     * @param id - int primary key of news
     * @return News by id
     */
    News getNews(int id);

    /**
     * This method add a new news
     *
     * @param news - parameter to addNews method, type News
     * @return int result of operation (if > 0 - successfully)
     */
    int addNews(News news);

    /**
     * This method delete one news by id
     *
     * @param id int primary key for news
     * @return int result of operation (if > 0 - successfully)
     */
    int deleteNews(int id);

    /**
     * This method edit news
     *
     * @param news - news for editting
     * @return int result of operation (if > 0 - successfully)
     */
    int editNews(News news);

    /**
     * Getting list of all news from table
     *
     * @return List Collection of all news
     */
    List<News> getAllNews();

    /**
     * Getting list of all news from table sorted by common category
     *
     * @param category - common category
     * @return List Collection of all news sorted by category
     */
    List<News> getNewsByCategoryId(String category);

}
