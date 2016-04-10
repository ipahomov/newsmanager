package by.it.academy.services;

import by.it.academy.model.Category;

import java.util.List;

/**
 * interface for categories service
 */
public interface ICategoryService {

    /**
     * Get all categories
     * @return List Collection of all categories
     */
    List<Category> getAllCategories();

    List<Category> getCategoriesByParentId(String parentId);

    Category getCategory(String id);

    int addCategory(Category category);

}
