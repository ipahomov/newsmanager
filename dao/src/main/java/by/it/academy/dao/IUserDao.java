package by.it.academy.dao;

import by.it.academy.model.User;

/**
 * interface for users
 */
public interface IUserDao {
    User getUserByEmail(String email);
}
