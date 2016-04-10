package by.it.academy.services;

import by.it.academy.dao.INewsDao;
import by.it.academy.dao.NewsDao;
import by.it.academy.model.News;

import java.util.List;

/**
 * Realisation of INewsService interface
 */
public class NewsService implements INewsService {
    private INewsDao newsDao;

    public NewsService(){
        newsDao = NewsDao.getInstance();
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
}
