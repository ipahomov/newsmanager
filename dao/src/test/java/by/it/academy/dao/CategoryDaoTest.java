package by.it.academy.dao;

import by.it.academy.model.Category;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by IPahomov on 04.05.2016.
 */
public class CategoryDaoTest {

    @Autowired
    ICategoryDao categoryDao;

    @Test
    public void testAddCategory() throws Exception {
        Category category = new Category();
        category.setCategoryName("test");
        category.setParentName("testParent");
        categoryDao.save(category);

    }

    @Test
    public void testGetCategoriesByParent() throws Exception {
        List<Category> categories = categoryDao.getCategoriesByParent("main");
        assertNotNull(categories);

    }

    @Ignore
    @Test
    public void testDeleteCategory() throws Exception {
        Category category = categoryDao.get(Category.class,7L);
        //UserDetail userDetail = category.getUserDetail();
        //UserDetailDao userDetailDao = UserDetailDao.getUserDetailsDao();
        //userDetailDao.delete(userDetail);

        categoryDao.delete(category);
        assertNull(categoryDao.get(Category.class,1L));

    }

    @Test
    public void testGetCategory() throws Exception {
        Category category = categoryDao.get(Category.class,8L);
        assertNotNull(category);

    }


    @Test
    public void testUpdateCategory() throws Exception {
        Category category = categoryDao.get(Category.class,8L);
        category.setCategoryName("testUpdate");
        category.setParentName("testParentUpdate");
        categoryDao.save(category);

    }
}