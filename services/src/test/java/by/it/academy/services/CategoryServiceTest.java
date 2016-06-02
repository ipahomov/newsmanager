package by.it.academy.services;

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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Tests for category entity
 * Created by IPahomov on 28.05.2016.
 */
@ContextConfiguration("/beans-TestServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CategoryServiceTest {
    private final static Logger log = Logger.getLogger(CategoryServiceTest.class);
    private Category category;

    @Autowired
    private ICategoryService categoryService;

    @Before
    public void prepareCategory() {
        category = new Category();
        category.setCategoryName("TestCategory");
        category.setParentName("TestCategoryParent");
    }

    @Test
    public void testSave() throws Exception {
        Long id = categoryService.save(category);
        assertNotNull(id);
        assertNotNull(categoryService.get(Category.class, id));

        log.info("Saved category: " + category);    }

    @Test
    public void testGet() throws Exception {
        Long id = categoryService.save(category);
        Category category = categoryService.get(Category.class, id);
        assertNotNull(category);
        log.info("Get category: " + category);
    }

    @Test
    public void testDelete() throws Exception {
        Long id = categoryService.save(category);
        Category categoryTest = categoryService.get(Category.class, id);

        categoryService.delete(categoryTest);
        assertNull(categoryService.get(Category.class, id));
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = categoryService.save(category);
        log.info("Saved category: " + category);

        Category categoryTest = categoryService.get(Category.class, id);
        categoryTest.setCategoryName("testUpdate");
        categoryTest.setParentName("testParentUpdate");
        categoryService.update(categoryTest);

        Category updatedCategory = categoryService.get(Category.class, id);
        assertNotNull(updatedCategory);
        assertEquals("testUpdate", updatedCategory.getCategoryName());
        log.info(updatedCategory);
    }

    @Test
    public void testGetCategoriesByParent() throws Exception {
        categoryService.save(category);
        List<Category> categories = categoryService.getCategoriesByParent("TestCategoryParent");
        log.info("Categories: " + categories.toString());

        assertNotNull(categories);
        assertEquals("Size", 1, categories.size());
    }
}