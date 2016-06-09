package by.it.academy.dao;

import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.News;

import java.util.List;

/**
 * Interface for operations with news
 */
public interface INewsDao extends IBaseDao<News, Long> {

    /**
     * This method for edit news
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

    /**
     * Method for pagination
     * @param firstResult beginning of requested results
     * @param newsPerPage news per page
     * @return list of results (news)
     * @throws DaoException
     */
    List<News> getNewsPagination(int firstResult, int newsPerPage) throws DaoException;

    /**
     * Count news for pagination
     * @return count of all news in data base
     * @throws DaoException
     */
    int getCountNews() throws DaoException;

}
