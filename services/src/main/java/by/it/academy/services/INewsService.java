package by.it.academy.services;

import by.it.academy.model.News;

import java.util.List;

/**
 * Interface for news service
 */
public interface INewsService extends IBaseService<News, Long> {

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
    List<News> getNewsByCategory(String category);

    /**
     * Get news list with pagination
     * @param firstResult first news from list
     * @param newsPerPage maximum news per page
     * @return list news
     */
    List<News> getNewsPagination(int firstResult, int newsPerPage);

    /**
     * Get count of all news in database.
     * @return int count of news
     */
    int getCountNews();

}
