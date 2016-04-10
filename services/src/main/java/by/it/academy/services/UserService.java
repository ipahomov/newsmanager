package by.it.academy.services;

import by.it.academy.dao.IUserDao;
import by.it.academy.dao.UserDao;
import by.it.academy.model.User;

/**
 *
 */
public class UserService implements IUserService {
    private IUserDao userDao;

    public UserService(){
        userDao = UserDao.getInstance();
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
