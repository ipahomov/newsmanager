package by.it.academy.services;

import by.it.academy.dao.CategoryDao;
import by.it.academy.dao.ICategoryDao;
import by.it.academy.model.Category;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for category services layer
 */
public class CategoryServiceTest {
    ICategoryService categoryService = CategoryService.getCategoryService();
    ICategoryDao categoryDao = CategoryDao.getCategoryDao();

    @Test
    public void testGetCategoryService() throws Exception {
        categoryService = CategoryService.getCategoryService();
        assertEquals(categoryService, CategoryService.getCategoryService());
    }

    @Test
    public void testGetAllCategories() throws Exception {
        List<Category> categoryList = categoryDao.getAllCategories();
        assertEquals(categoryList, categoryService.getAllCategories());
    }

    @Test
    public void testGetCategoriesByParentId() throws Exception {
        List<Category> categoryList = categoryDao.getCategoriesByParentId("main");
        assertEquals(categoryList, categoryService.getCategoriesByParentId("main"));
    }

    @Test
    public void testGetCategory() throws Exception {
        Category category = categoryDao.getCategory("sport");
        assertEquals(category, categoryService.getCategory("sport"));

    }
}