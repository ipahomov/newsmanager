package by.it.academy.services;

import by.it.academy.model.Category;

import java.util.List;

/**
 * interface for categories service
 */
public interface ICategoryService {

    /**
     * Get all categories
     *
     * @return List Collection of all categories
     */
    List<Category> getAllCategories();

    /**
     * Get all categories sorted by parent category
     *
     * @param parentId parent category
     * @return List Collection of all categories sorted by parent category
     */
    List<Category> getCategoriesByParentId(String parentId);

    /**
     * Get one category by id
     *
     * @param id of category
     * @return category
     */
    Category getCategory(String id);

    /**
     * Add a new category of news
     *
     * @param category of news
     * @return result of add operation (if > 0 - successfully)
     */
    int addCategory(Category category);

}
