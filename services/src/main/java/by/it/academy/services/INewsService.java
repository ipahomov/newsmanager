package by.it.academy.services;

import by.it.academy.model.News;

import java.util.List;

/**
 * interface for news service
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

    List<News> getNewsPagination(int result, int offset);

    int getCountNews();

}
