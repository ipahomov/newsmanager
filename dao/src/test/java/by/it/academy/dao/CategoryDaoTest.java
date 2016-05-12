package by.it.academy.dao;

import by.it.academy.model.Category;
import by.it.academy.model.UserDetail;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by IPahomov on 04.05.2016.
 */
public class CategoryDaoTest {
    CategoryDao categoryDao = CategoryDao.getCategoryDao();

    @Test
    public void testAddCategory() throws Exception {

        Category category = new Category();
        category.setCategoryName("main");
        //category.setParentName("main");
        categoryDao.save(category);

    }

    @Test
    public void testGetCategoriesByParent() throws Exception {
        List<Category> categories = categoryDao.getCategoriesByParent("main");
        assertNotNull(categories);

    }

    @Test
    public void testDeleteCategory() throws Exception {
        Category category = categoryDao.get(1L);
        UserDetail userDetail = category.getUserDetail();
        UserDetailDao userDetailDao = UserDetailDao.getUserDetailsDao();
        categoryDao.delete(category);
        userDetailDao.delete(userDetail);

        assertNull(categoryDao.get(1L));

    }

    @Test
    public void testGetCategory() throws Exception {
        Category category = categoryDao.get(2L);
        assertNotNull(category);

    }
}