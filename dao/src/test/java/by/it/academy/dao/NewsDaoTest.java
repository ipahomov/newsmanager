package by.it.academy.dao;

import by.it.academy.model.News;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Tests for news DAO layer
 */
public class NewsDaoTest {
    INewsDao newsDao = NewsDao.getNewsDao();

    @Test
    public void testGetNewsDao() throws Exception {
        INewsDao newsDao1 = NewsDao.getNewsDao();
        assertEquals(newsDao, newsDao1);

    }

    @Test
    public void testAddNews() throws Exception {
        News news = new News();
        news.setCategoryId("testDao");
        news.setTitle("testDao");
        news.setAuthor("testDao");
        news.setAnnotation("testDao");
        news.setMaintext("testDao");
        int result = newsDao.addNews(news);
        assertEquals(1, result);
    }

    @Test
    public void testGetNews() throws Exception {
        News lastNews = getTestNews();
        News news = newsDao.getNews(lastNews.getId());
        assertEquals(lastNews, news);
    }

    @Test
    public void testEditNews() throws Exception {
        News news = getTestNews();
        news.setCategoryId("testDaoEdit");
        news.setTitle("testDaoEdit");
        news.setAuthor("testDaoEdit");
        news.setAnnotation("testDaoEdit");
        news.setMaintext("testDaoEdit");
        int result = newsDao.editNews(news);
        assertEquals(1, result);
    }

    @Test
    public void testDeleteNews() throws Exception {
        News news = getTestNews();
        int result = newsDao.deleteNews(news.getId());
        assertEquals(1, result);
    }

    @Test
    public void testGetAllNews() throws Exception {
        List<News> newsList1 = newsDao.getAllNews();
        List<News> newsList2 = newsDao.getAllNews();
        assertEquals(newsList1, newsList2);
    }

    @Test
    public void testGetNewsByCategoryId() throws Exception {
        List<News> newsList1 = newsDao.getNewsByCategoryId("sport");
        List<News> newsList2 = newsDao.getNewsByCategoryId("sport");
        assertEquals(newsList1, newsList2);
    }

    public News getTestNews() {
        List<News> newsList = newsDao.getAllNews();
        int lastNewsIndex = newsList.size();
        News lastNews = newsList.get(lastNewsIndex - 1);
        int lastId = lastNews.getId();

        News news = newsDao.getNews(lastId);
        return news;
    }
}