package by.it.academy.services;

import by.it.academy.dao.CategoryDao;
import by.it.academy.dao.ICategoryDao;
import by.it.academy.model.Category;

import java.util.List;

/**
 * Class implementing ICategoryService interface
 * Realizes methods with category operations
 */
public class CategoryService implements ICategoryService {
    private ICategoryDao categoryDao;
    private static CategoryService categoryService;

    /**
     * Singleton pattern
     */
    private CategoryService() {
        categoryDao = CategoryDao.getCategoryDao();
    }

    public static CategoryService getCategoryService() {
        if (categoryService == null)
            categoryService = new CategoryService();
        return categoryService;
    }

    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    public List<Category> getCategoriesByParentId(String parentId) {
        return categoryDao.getCategoriesByParentId(parentId);
    }

    public Category getCategory(String id) {
        return categoryDao.getCategory(id);
    }
}
