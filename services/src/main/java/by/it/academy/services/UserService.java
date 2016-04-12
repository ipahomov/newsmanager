package by.it.academy.services;

import by.it.academy.dao.IUserDao;
import by.it.academy.dao.UserDao;
import by.it.academy.model.User;

/**
 * Class implementing IUserService interface
 * Realizes user operations.
 */
public class UserService implements IUserService {
    private IUserDao userDao;
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
        return userDao.getUserByEmail(email);
    }
}
