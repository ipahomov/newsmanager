package by.it.academy.dao;

import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.User;
import by.it.academy.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 * Created by IPahomov on 04.05.2016.
 * Class implementing IUserDao interface.
 * Realizes all methods for operations with users table in database
 * Must be a singleton class.
 */
public class UserDao extends BaseDao<User> implements IUserDao {
    final static Logger logger = Logger.getLogger(UserDao.class);

    private static UserDao userDao;

    /**
     * Singleton pattern
     */
    private UserDao() {
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }


    public User getUserByEmail(String email) throws DaoException {
        Criteria criteria;
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", email));
        } catch (HibernateException e) {
            logger.error("Error get user by email " + e);
            throw new DaoException(e);
        }

        return (User) criteria.uniqueResult();
    }
}
