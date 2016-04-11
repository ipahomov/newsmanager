package by.it.academy.dao;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Leckter on 11.04.2016.
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

    }

    @Test
    public void testGetNews() throws Exception {

    }

    @Test
    public void testDeleteNews() throws Exception {

    }

    @Test
    public void testEditNews() throws Exception {

    }

    @Test
    public void testGetAllNews() throws Exception {

    }

    @Test
    public void testGetNewsByCategoryId() throws Exception {

    }
}