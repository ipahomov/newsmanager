package by.it.academy.services.impl;

import by.it.academy.dao.INewsDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.News;
import by.it.academy.services.INewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Class implementing INewsService interface.
 * Contains main news operations.
 */
@Service("newsService")
@Transactional
public class NewsService extends BaseService<News, Long> implements INewsService {
    private final static Logger log = Logger.getLogger(NewsService.class);

    @Autowired
    private INewsDao newsDao;

    public List<News> getAllNews() {
        List<News> newsList = Collections.EMPTY_LIST;
        try {
            newsList = newsDao.getAllNews();
        } catch (DaoException e) {
            log.error("Error get all news " + e);
        }
        return newsList;
    }

    public List<News> getNewsByCategory(String category) {
        List<News> newsList = Collections.EMPTY_LIST;
        try {
            newsList = newsDao.getNewsByCategory(category);
        } catch (DaoException e) {
            log.error("Error get news by category " + e);
        }
        return newsList;
    }

    public List<News> getNewsPagination(int firstResult, int newsPerPage) {
        List<News> newsList = Collections.EMPTY_LIST;
        if(firstResult < 1) firstResult = 0;
        //int startPosition = (firstResult-1)*newsPerPage;
        try {
            newsList = newsDao.getNewsPagination(firstResult, newsPerPage);
        } catch (DaoException e) {
            log.error("Error get news pagination " + e);
        }
        return newsList;
    }

    public int getCountNews() {
        int count = 0;
        try {
            count = newsDao.getCountNews();
        } catch (DaoException e) {
            log.error("Error get count news " + e);
        }
        return count;
    }
}
