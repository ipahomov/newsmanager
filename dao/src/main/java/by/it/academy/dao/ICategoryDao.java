package by.it.academy.dao;

import by.it.academy.model.Category;

import java.util.List;

/**
 * interface for categories
 */
public interface ICategoryDao {

    List<Category> getAllCategories();

    List<Category> getCategoriesByParentId(String parentId);

    Category getCategory(String id);

    int addCategory(Category category);
}
