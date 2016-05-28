package by.it.academy.dao;

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
 * Tests news operations.
 * Created by IPahomov on 03.05.2016.
 */
@ContextConfiguration("/beans-TestDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class NewsDaoTest {
    private final static Logger log = Logger.getLogger(UserDaoTest.class);
    private News news;

    @Autowired
    INewsDao newsDao;

    @Before
    public void prepareNews(){
        news = new News();
        news.setTitle("testTitle");
        news.setCategoryName("testCategory");
        news.setAnnotation("testAnnotation");
        news.setAuthor("testAuthor");
        news.setMaintext("testMainText");
        news.setReleaseDate(new Date());
    }

    @Test
    public void testAddNews() throws Exception {
        Long id = newsDao.save(news);
        assertNotNull(newsDao.get(News.class, id));
        log.info("Saved news: " + news);
    }

    @Test
    public void testGetNews() throws Exception {
        Long id = newsDao.save(news);
        News news = newsDao.get(News.class,id);
        assertNotNull(news);
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = newsDao.save(news);
        log.info("Saved news: " + news);

        News testNews = newsDao.get(News.class, id);
        testNews.setTitle("UpdatedTitle");
        newsDao.update(testNews);

        News updatedNews = newsDao.get(News.class, id);
        assertNotNull(updatedNews);
        assertEquals("UpdatedTitle", updatedNews.getTitle());
        log.info("Updated news: " + updatedNews);
    }

    @Test
    public void testDelete() throws Exception {
        Long id = newsDao.save(news);
        News testNews = newsDao.get(News.class, id);

        newsDao.delete(testNews);
        assertNull(newsDao.get(News.class, id));
    }

    @Test
    public void testGetAllNews() throws Exception {
        newsDao.save(news);
        List<News> newsList = newsDao.getAllNews();
        assertNotNull(newsList);
        assertNotEquals("Not empty",0, newsList.size());
    }

    @Test
    public void testGetNewsByCategory() throws Exception {
        newsDao.save(news);
        String categoryName = "testCategory";
        List<News> newsList = newsDao.getNewsByCategory(categoryName);
        assertNotNull(newsList);
        assertNotEquals("Not empty",0, newsList.size());

    }
}