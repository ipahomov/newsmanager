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
        news.setCategoryId("testNewsServiceAdd");
        news.setAnnotation("testNewsServiceAdd");
        news.setAuthor("testNewsServiceAdd");
        news.setTitle("testNewsServiceAdd");
        news.setMaintext("testNewsServiceAdd");
        int result = newsService.addNews(news);
        assertEquals(1, result);
    }

    @Test
    public void testGetNews() throws Exception {
        News lastNews = getTestNews();
        News news = newsService.getNews(lastNews.getId());
        assertEquals(lastNews, news);
    }

    @Test
    public void testEditNews() throws Exception {
        News news = getTestNews();
        news.setCategoryId("testNewsServiceEdit");
        news.setAnnotation("testNewsServiceEdit");
        news.setAuthor("testNewsServiceEdit");
        news.setTitle("testNewsServiceEdit");
        news.setMaintext("testNewsServiceEdit");
        int result = newsService.editNews(news);
        assertEquals(1, result);
    }

    @Test
    public void testDeleteNews() throws Exception {
        News news = getTestNews();
        int result = newsService.deleteNews(news.getId());
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

    public News getTestNews() {
        List<News> newsList = newsService.getAllNews();
        int lastNewsIndex = newsList.size();
        News lastNews = newsList.get(lastNewsIndex - 1);
        int lastId = lastNews.getId();

        News news = newsService.getNews(lastId);
        return news;
    }

}