package by.it.academy.services;

import by.it.academy.dao.NewsDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.News;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Class implementing INewsService interface.
 * Contains main news operations.
 */
public class NewsService implements INewsService {
    final static Logger logger = Logger.getLogger(CategoryService.class);
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
        if(news != null) {
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
        return newsDao.getAllNews();
    }

    public List<News> getNewsByCategory(String category) {
        return newsDao.getNewsByCategory(category);
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
