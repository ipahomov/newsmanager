package by.it.academy.dao;

import by.it.academy.model.Category;

import java.util.List;

/**
 * interface for categories
 */
public interface ICategoryDao {

    /**
     * This method return all categories from table
     *
     * @return List Collection of all categories
     */
    List<Category> getAllCategories();

    /**
     * This method return all categories from table sorted by common parent
     *
     * @param parentId - name of common parent
     * @return List Collection of all categories sorted by parent
     */
    List<Category> getCategoriesByParentId(String parentId);

    /**
     * This method getting one name of category by id
     *
     * @param id (type String) of category (name)
     * @return one Category
     */
    Category getCategory(String id);

    /**
     * This method add a new category
     *
     * @param category - new category for adding
     * @return int result of operation (if > 0 - successfully)
     */
    int addCategory(Category category);

    /**
     * This method for delete one category from table by id
     *
     * @param catId (type String) of category (name)
     * @return int result of operation (if > 0 - successfully)
     */
    int deleteCategory(String catId);
}
