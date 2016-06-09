package by.it.academy.dao;

import by.it.academy.model.Category;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.*;

/**
 * Test category operations.
 * Created by IPahomov on 04.05.2016.
 */
@ContextConfiguration("/beans-TestDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CategoryDaoTest {
    private final static Logger log = Logger.getLogger(UserDaoTest.class);
    private Category category;

    @Autowired
    ICategoryDao categoryDao;

    @Before
    public void prepareCategory() {
        category = new Category();
        category.setCategoryName("TestCategory");
        category.setParentName("TestCategoryParent");
    }

    @Test
    public void testAddCategory() throws Exception {
        Long id = categoryDao.save(category);
        assertNotNull(id);
        assertNotNull(categoryDao.get(Category.class, id));

        log.info("Saved category: " + category);
    }

    @Test
    public void testGetCategoriesByParent() throws Exception {
        categoryDao.save(category);
        List<Category> categories = categoryDao.getCategoriesByParent("TestCategoryParent");
        log.info("Categories: " + categories.toString());
        assertNotNull(categories);
        assertEquals("Size", 1, categories.size());
    }

    @Test
    public void testDeleteCategory() throws Exception {
        Long id = categoryDao.save(category);
        Category categoryTest = categoryDao.get(Category.class, id);

        categoryDao.delete(categoryTest);
        assertNull(categoryDao.get(Category.class, id));
    }

    @Test
    public void testGetCategory() throws Exception {
        Long id = categoryDao.save(category);
        Category category = categoryDao.get(Category.class, id);
        assertNotNull(category);
        log.info("Get category: " + category);

    }

    @Test
    public void testUpdateCategory() throws Exception {
        Long id = categoryDao.save(category);
        log.info("Saved category: " + category);
        Category categoryTest = categoryDao.get(Category.class, id);
        categoryTest.setCategoryName("testUpdate");
        categoryTest.setParentName("testParentUpdate");
        categoryDao.update(categoryTest);

        Category updatedCategory = categoryDao.get(Category.class, id);
        assertNotNull(updatedCategory);
        assertEquals("testUpdate", updatedCategory.getCategoryName());
        log.info(updatedCategory);
    }
}