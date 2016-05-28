package by.it.academy.dao;

import by.it.academy.model.News;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by IPahomov on 03.05.2016.
 */
public class NewsDaoTest {
    @Autowired
    INewsDao newsDao;

    @Test
    public void testAddNews() throws Exception {

        News news = new News();
        news.setTitle("testTitle4");
        news.setCategoryName("sport");
        news.setAnnotation("testAnnotation4");
        news.setAuthor("testAuthor4");
        news.setMaintext("testMainText4");
        //news.setReleaseDate(new Date());

        newsDao.save(news);
    }

    @Test
    public void testGetNews() throws Exception {
        News news = newsDao.get(News.class,23L);
        assertNotNull(news);
    }


    @Test
    public void testGetAllNews() throws Exception {
        List<News> newsList = newsDao.getAllNews();
        assertNotNull(newsList);
        assertNotEquals("Not empty",0, newsList.size());
    }

    @Test
    public void testGetNewsByCategory() throws Exception {
        String categoryName = "sport";
        List<News> newsList = newsDao.getNewsByCategory(categoryName);
        assertNotNull(newsList);
        assertNotEquals("Not empty",0, newsList.size());

    }
}