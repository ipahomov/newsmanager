package by.it.academy.dao;

import by.it.academy.model.Category;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Leckter on 11.04.2016.
 */
public class CategoryDaoTest {
    ICategoryDao categoryDao = CategoryDao.getCategoryDao();

    @Test
    public void testGetCategoryDao() throws Exception {
        ICategoryDao categoryDao1 = CategoryDao.getCategoryDao();
        assertEquals(categoryDao, categoryDao1);
    }

    @Test
    public void testGetAllCategories() throws Exception {
        List<Category> categoryList1 = categoryDao.getAllCategories();
        List<Category> categoryList2 = categoryDao.getAllCategories();
        assertEquals(categoryList1, categoryList2);
    }

    @Test
    public void testGetCategoriesByParentId() throws Exception {
        String categoryParent = "main";
        List<Category> categoryList1 = categoryDao.getCategoriesByParentId(categoryParent);
        List<Category> categoryList2 = categoryDao.getCategoriesByParentId(categoryParent);
        assertEquals(categoryList1, categoryList2);
    }

    @Test
    public void testAddCategory() throws Exception {
        Category category = new Category();
        category.setCatId("testId");
        category.setParentId("testParentId");
        int result = categoryDao.addCategory(category);
        assertEquals(1, result);
    }

    @Test
    public void testGetCategory() throws Exception {
        Category category = categoryDao.getCategory("sport");
        assertEquals("sport", category.getCatId());


    }

    @Test
    public void testDeleteCategory() throws Exception {
        int result = categoryDao.deleteCategory("testId");
        assertEquals(1, result);
    }

}