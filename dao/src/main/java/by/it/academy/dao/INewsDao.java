package by.it.academy.dao;

import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.News;

import java.util.List;

/**
 * interface for operations with news
 */
public interface INewsDao {

    /**
     * This method edit news
     *
     * @param news - news for editting
     * @return int result of operation (if > 0 - successfully)
     */
    //void editNews(News news) throws DaoException;

    /**
     * Getting list of all news from table
     *
     * @return List Collection of all news
     */
    List<News> getAllNews() throws DaoException;

    /**
     * Getting list of all news from table sorted by common category
     *
     * @param categoryName - common category
     * @return List Collection of all news sorted by category
     */
    List<News> getNewsByCategory(String categoryName) throws DaoException;

}
