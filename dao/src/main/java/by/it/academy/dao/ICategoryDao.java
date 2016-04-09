package by.it.academy.dao;

import by.it.academy.model.Category;

import java.util.List;

/**
 * interface for categories
 */
public interface ICategoryDao {

    List<Category> getAllCategories();

    Category getCategoryById(String id);

    int addCat(Category category);
}
