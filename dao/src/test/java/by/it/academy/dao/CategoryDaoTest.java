package by.it.academy.dao;

import by.it.academy.model.Category;
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
        category.setCategoryName("economy");
        category.setParentName("main");
        categoryDao.save(category);

    }

    @Test
    public void testGetCategoriesByParent() throws Exception {
        List<Category> categories = categoryDao.getCategoriesByParent("main");
        assertNotNull(categories);

    }
}