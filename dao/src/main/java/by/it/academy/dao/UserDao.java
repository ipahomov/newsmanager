package by.it.academy.dao;

import by.it.academy.model.User;
import by.it.academy.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 * Created by IPahomov on 04.05.2016.
 * Class implementing IUserDao interface.
 * Realizes all methods for operations with users table in database
 * Must be a singleton class.
 */
public class UserDao extends BaseDao<User> implements IUserDao  {
    final static Logger logger = Logger.getLogger(UserDao.class);

    private static UserDao userDao;

    /**
     * Singleton pattern
     */
    private UserDao() {
    }

    public static UserDao getUserDaoHiber() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }


    public User getUserByEmail(String email) {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();

        return user;
    }
}
