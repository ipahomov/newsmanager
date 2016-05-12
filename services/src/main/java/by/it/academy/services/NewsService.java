package by.it.academy.services;

import by.it.academy.dao.NewsDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.News;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;

/**
 * Class implementing INewsService interface.
 * Contains main news operations.
 */
public class NewsService implements INewsService {
    final static Logger logger = Logger.getLogger(NewsService.class);
    private NewsDao newsDao;
    private static NewsService newsService;

    /**
     * Singleton pattern
     */
    private NewsService() {
        newsDao = NewsDao.getNewsDao();
    }

    public static NewsService getNewsService() {
        if (newsService == null)
            newsService = new NewsService();
        return newsService;
    }

    public void addNews(News news) {
        try {
            newsDao.save(news);
        } catch (DaoException e) {
            logger.error("Error add news" + e);
        }
    }

    public void deleteNews(Long id) {
        News news = null;
        try {
            news = newsDao.get(id);
        } catch (DaoException e) {
            logger.error("Error get news to delete" + e);
        }
        if (news != null) {
            try {
                newsDao.delete(news);
            } catch (DaoException e) {
                logger.error("Error delete news" + e);
            }
        }
    }

    public void editNews(News news) {
        try {
            newsDao.saveOrUpdate(news);
        } catch (DaoException e) {
            logger.error("Error edit news" + e);
        }
    }

    public List<News> getAllNews() {
        List<News> newsList = Collections.EMPTY_LIST;
        try {
            newsList = newsDao.getAllNews();
        } catch (DaoException e) {
            logger.error("Error getAllNews service " + e);
        }
        return newsList;
    }

    public List<News> getNewsByCategory(String category) {
        List<News> newsList = Collections.EMPTY_LIST;
        try {
            newsList = newsDao.getNewsByCategory(category);
        } catch (DaoException e) {
            logger.error("Error getNewsByCategory service " + e);
        }
        return newsList;
    }

    public News getNews(Long id) {
        News news = null;
        try {
            news = newsDao.get(id);
        } catch (DaoException e) {
            logger.error("Error get news" + e);
        }
        return news;
    }
}
