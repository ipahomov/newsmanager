package by.it.academy.services;

import by.it.academy.dao.CategoryDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.Category;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Class implementing ICategoryService interface
 * Realizes methods with category operations
 */
public class CategoryService implements ICategoryService {
    final static Logger logger = Logger.getLogger(CategoryService.class);
    private CategoryDao categoryDao;
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


    public void addCategory(Category category){
        try {
            categoryDao.save(category);
        } catch (DaoException e) {
            logger.error("Error add category" + e);
        }
    }

    public List<Category> getCategoriesByParent(String parentId) {
        return categoryDao.getCategoriesByParent(parentId);
    }

    public Category getCategory(String id){
        Category category = null;
        try {
            category = categoryDao.get(id);
        } catch (DaoException e) {
            logger.error("Error get category" + e);
        }
        return category;
    }

    public void editCategory(Category category){
        try {
            categoryDao.saveOrUpdate(category);
        } catch (DaoException e) {
            logger.error("Error edit category" + e);
        }
    }
}
