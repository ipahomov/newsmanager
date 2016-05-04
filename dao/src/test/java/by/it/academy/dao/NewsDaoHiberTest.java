package by.it.academy.dao;

import by.it.academy.model.News;
import org.junit.Test;

import java.util.Date;

/**
 * Created by IPahomov on 03.05.2016.
 */
public class NewsDaoHiberTest {

    @Test
    public void testAddNews() throws Exception {
        NewsDaoHiber newsDaoHiber = new NewsDaoHiber();

        News news = new News();
        news.setTitle("testTitle123");
        news.setCategoryName("building");
        news.setAnnotation("testAnnotation");
        news.setAuthor("testAuthor");
        news.setMaintext("testMainText");
        news.setReleaseDate(new Date());

        newsDaoHiber.save(news);
    }

}