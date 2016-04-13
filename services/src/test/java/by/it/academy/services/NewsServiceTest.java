package by.it.academy.services;

import by.it.academy.dao.INewsDao;
import by.it.academy.dao.NewsDao;
import by.it.academy.model.News;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Leckter on 11.04.2016.
 */
public class NewsServiceTest {
    INewsService newsService = NewsService.getNewsService();
    INewsDao newsDao = NewsDao.getNewsDao();

    @Test
    public void testGetNewsService() throws Exception {
        assertEquals(newsService, NewsService.getNewsService());
    }

    @Test
    public void testAddNews() throws Exception {
        News news = new News();
        news.setCategoryId("test");
        news.setAnnotation("test");
        news.setAuthor("test");
        news.setTitle("test");
        news.setMaintext("test");
        int result = newsService.addNews(news);
        assertEquals(1, result);
    }

    @Test
    public void testGetNews() throws Exception {
        List<News> newsList = newsService.getAllNews();
        int lastNewsIndex = newsList.size();
        News lastNews = newsList.get(lastNewsIndex-1);
        int lastId = lastNews.getId();

        News news = newsService.getNews(lastId);
        assertEquals(lastNews, news);
    }

    @Test
    public void testEditNews() throws Exception {
        List<News> newsList = newsService.getAllNews();
        int lastNewsIndex = newsList.size();
        News lastNews = newsList.get(lastNewsIndex-1);
        int lastId = lastNews.getId();

        News news = newsService.getNews(lastId);
        news.setCategoryId("test2");
        news.setAnnotation("test2");
        news.setAuthor("test2");
        news.setTitle("test2");
        news.setMaintext("test2");
        int result = newsService.editNews(news);
        assertEquals(1, result);
    }

    @Test
    public void testDeleteNews() throws Exception {
        List<News> newsList = newsService.getAllNews();
        int lastNewsIndex = newsList.size();
        News lastNews = newsList.get(lastNewsIndex-1);
        int lastId = lastNews.getId();

        int result = newsService.deleteNews(lastId);
        assertEquals(1, result);
    }



    @Test
    public void testGetAllNews() throws Exception {
        List<News> newsList1 = newsDao.getAllNews();
        List<News> newsList2 = newsService.getAllNews();
        assertEquals(newsList1,newsList2);
    }

    @Test
    public void testGetNewsByCategoryId() throws Exception {
        List<News> newsList1 = newsDao.getNewsByCategoryId("sport");
        List<News> newsList2 = newsService.getNewsByCategoryId("sport");
        assertEquals(newsList1,newsList2);
    }


}