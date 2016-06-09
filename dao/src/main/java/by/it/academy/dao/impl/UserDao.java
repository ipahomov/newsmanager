package by.it.academy.dao.impl;

import by.it.academy.dao.IUserDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.user.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by IPahomov on 04.05.2016.
 * Class implementing IUserDao interface.
 * Realizes all methods for operations with users table in database
 * Must be a singleton class.
 */
@Repository("userDao")
public class UserDao extends BaseDao<User,Long> implements IUserDao {
    final static Logger logger = Logger.getLogger(UserDao.class);

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User getUserByEmail(String email) throws DaoException {
        Criteria criteria;
        try {
            criteria = getSession().createCriteria(User.class);
            criteria.add(Restrictions.eq("email", email));
        } catch (HibernateException e) {
            logger.error("Error get user by email " + e);
            throw new DaoException(e);
        }

        return (User) criteria.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
    }
}
