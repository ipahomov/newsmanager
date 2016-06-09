package by.it.academy.services;

import by.it.academy.model.Category;

import java.util.List;

/**
 * Interface for categories service
 */
public interface ICategoryService extends IBaseService<Category, Long> {

    /**
     * Get all categories sorted by parent category
     *
     * @param parentId parent category
     * @return List Collection of all categories sorted by parent category
     */
    List<Category> getCategoriesByParent(String parentId);

}
