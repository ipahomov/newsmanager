package by.it.academy.services;

import by.it.academy.model.News;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for news entity operations
 * Created by IPahomov on 28.05.2016.
 */
@ContextConfiguration("/beans-TestServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class NewsServiceTest {
    private final static Logger log = Logger.getLogger(NewsServiceTest.class);
    private News news;

    @Autowired
    private INewsService newsService;

    @Before
    public void prepareNews() {
        news = new News();
        news.setCategoryName("testCategory");
        news.setTitle("testTitle");
        news.setAnnotation("testAnnotation");
        news.setAuthor("testAuthor");
        news.setMaintext("testMainText");
        news.setReleaseDate(new Date());
    }

    @Test
    public void testGetAllNews() throws Exception {
        newsService.save(news);
        List<News> newsList = newsService.getAllNews();
        assertNotNull(newsList);
        assertNotEquals(0, newsList.size());
        log.info(newsList);
    }

    @Test
    public void testGet() throws Exception {
        Long id = newsService.save(news);
        News news = newsService.get(News.class, id);
        assertNotNull(news);
    }

    @Test
    public void testDelete() throws Exception {
        Long id = newsService.save(news);
        News testNews = newsService.get(News.class, id);

        newsService.delete(testNews);
        assertNull(newsService.get(News.class, id));
    }

    @Test
    public void testGetCountNews() throws Exception {
        newsService.save(news);
        int count = newsService.getCountNews();
        assertEquals("Count:", 1, count);
        log.info("Count of news: " + count);
    }

    @Test
    public void testGetNewsPagination() throws Exception {
        newsService.save(news);

        List<News> newsList1 = newsService.getNewsPagination(0, 2);
        assertNotNull(newsList1);
        assertEquals(1, newsList1.size());
        log.info(newsList1);

    }

    @Test
    public void testGetNewsByCategory() throws Exception {
        newsService.save(news);
        newsService.save(news);
        String categoryName = "testCategory";
        List<News> newsList = newsService.getNewsByCategory(categoryName);

        assertNotNull(newsList);
        assertNotEquals("Not empty", 0, newsList.size());
        log.info(newsList);
    }

    @Test
    public void testSave() throws Exception {
        Long id = newsService.save(news);
        assertNotNull(newsService.get(News.class, id));
        log.info("Saved news: " + news);
    }

    @Test
    public void testUpdate() throws Exception {
        Long savefId = newsService.save(news);
        log.info("Saved news by service: " + news);

        News testNews = newsService.get(News.class, savefId);
        testNews.setTitle("UpdatedTitle");
        newsService.update(testNews);
        News updatedNews = newsService.get(News.class, savefId);

        assertNotNull(updatedNews);
        assertEquals("UpdatedTitle", updatedNews.getTitle());
        log.info("Updated news: " + updatedNews);
    }
}