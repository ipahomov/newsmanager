package by.it.academy.services;

import by.it.academy.dao.CategoryDao;
import by.it.academy.dao.ICategoryDao;
import by.it.academy.model.Category;

import java.util.List;

/**
 *
 */
public class CategoryService implements ICategoryService {
    private ICategoryDao categoryDao;

    public CategoryService(){
        categoryDao = CategoryDao.getInstance();
    }

    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public Category getCategoryById(String id) {
        return categoryDao.getCategoryById(id);
    }

    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }
}
