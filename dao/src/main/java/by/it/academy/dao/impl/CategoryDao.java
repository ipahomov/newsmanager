package by.it.academy.dao.impl;

import by.it.academy.dao.ICategoryDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.Category;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * Class for database operations with categories.
 * Extends BaseDao and implements ICategoryDao
 * Created by IPahomov on 04.05.2016.
 */
@Repository("categoryDao")
public class CategoryDao extends BaseDao<Category, Long> implements ICategoryDao {
    final static Logger logger = Logger.getLogger(CategoryDao.class);

    @Autowired
    public CategoryDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Category> getCategoriesByParent(String parentName) throws DaoException {
        List<Category> categories = Collections.EMPTY_LIST;
        try {
            Criteria criteria = getSession().createCriteria(Category.class);
            criteria.add(Restrictions.eq("parentName", parentName));
            categories = criteria.list();
        } catch (HibernateException e) {
            logger.error("Error get categories by parent" + e);
            throw new DaoException(e);
        }

        return categories;
    }
}
