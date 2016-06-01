package by.it.academy.services;

import by.it.academy.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IPahomov on 28.05.2016.
 */
@ContextConfiguration("/beans-TestServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class NewsServiceTest {

    @Autowired
    private INewsService newsService;

    @Test
    public void testGetAllNews() throws Exception {
        List<News> newsList = newsService.getAllNews();
        assertNotNull(newsList);
        assertNotEquals(0, newsList.size());
        System.out.println(newsList);
    }

    @Test
    public void testGetNewsByCategory() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}