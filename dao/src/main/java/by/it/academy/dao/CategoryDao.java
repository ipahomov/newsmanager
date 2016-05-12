package by.it.academy.dao;

import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.Category;
import by.it.academy.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Collections;
import java.util.List;

/**
 * Class for database operations with categories.
 * Extends BaseDao and implements ICategoryDao
 * Created by IPahomov on 04.05.2016.
 */
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {
    final static Logger logger = Logger.getLogger(CategoryDao.class);
    private static CategoryDao categoryDao;

    /**
     * Singleton pattern
     */
    private CategoryDao() {
    }

    public static CategoryDao getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new CategoryDao();
        }
        return categoryDao;
    }

    public List<Category> getCategoriesByParent(String parentName) throws DaoException {
        List<Category> categories = Collections.EMPTY_LIST;
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            Criteria criteria = session.createCriteria(Category.class);
            criteria.add(Restrictions.eq("parentName", parentName));
            categories = criteria.list();
        } catch (HibernateException e) {
            logger.error("Error get categories by parent" + e);
            throw new DaoException(e);
        }

        return categories;
    }
}
