package by.it.academy.services.impl;

import by.it.academy.dao.ICategoryDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.Category;
import by.it.academy.services.ICategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Class implementing ICategoryService interface
 * Realizes methods with category operations
 */
@Service("categoryService")
@Transactional
public class CategoryService extends BaseService<Category, Long> implements ICategoryService {
    final static Logger log = Logger.getLogger(CategoryService.class);

    @Autowired
    private ICategoryDao categoryDao;

    public List<Category> getCategoriesByParent(String parentId) {
        List<Category> categoryList = Collections.EMPTY_LIST;
        try {
            categoryList = categoryDao.getCategoriesByParent(parentId);
        } catch (DaoException e) {
            log.error("Error get categories by parent category " + e);
        }

        return categoryList;
    }

}
