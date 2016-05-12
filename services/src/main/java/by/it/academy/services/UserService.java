package by.it.academy.services;

import by.it.academy.dao.UserDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.User;
import org.apache.log4j.Logger;

/**
 * Class implementing IUserService interface
 * Realizes user operations.
 */
public class UserService implements IUserService {
    final static Logger logger = Logger.getLogger(UserService.class);
    private UserDao userDao;
    private static UserService userService;

    /**
     * Singleton pattern
     */
    private UserService() {
        userDao = UserDao.getUserDao();
    }

    public static UserService getUserService() {
        if (userService == null)
            userService = new UserService();
        return userService;
    }

    public User getUserByEmail(String email) {
        User user = null;
        try {
            user = userDao.getUserByEmail(email);
        } catch (DaoException e) {
            logger.error("Error getNewsByCategory service " + e);
        }
        return user;
    }
}
