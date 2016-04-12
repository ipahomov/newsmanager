package by.it.academy.services;

import by.it.academy.dao.INewsDao;
import by.it.academy.dao.NewsDao;
import by.it.academy.model.News;

import java.util.List;

/**
 * Class implementing INewsService interface.
 * Contains main news operations.
 */
public class NewsService implements INewsService {
    private INewsDao newsDao;
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

    public int addNews(News news) {
        return newsDao.addNews(news);
    }

    public int deleteNews(int id) {
        return newsDao.deleteNews(id);
    }

    public int editNews(News news) {
        return newsDao.editNews(news);
    }

    public List<News> getAllNews() {
        return newsDao.getAllNews();
    }

    public List<News> getNewsByCategoryId(String category) {
        return newsDao.getNewsByCategoryId(category);
    }

    public News getNews(int id) {
        return newsDao.getNews(id);
    }
}
