package by.it.academy.dao;

import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.Category;

import java.util.List;

/**
 * interface for categories
 */
public interface ICategoryDao extends IBaseDao<Category, Long> {

    /**
     * This method return all categories from table sorted by common parent
     *
     * @param parentName - name of common parent
     * @return List Collection of all categories sorted by parent
     */
    List<Category> getCategoriesByParent(String parentName) throws DaoException;


}
