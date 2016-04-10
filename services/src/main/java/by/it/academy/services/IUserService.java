package by.it.academy.services;

import by.it.academy.model.User;

/**
 * interface for user service
 */
public interface IUserService {

    /**
     * Getting user from dao module
     * @param email of user
     * @return user
     */
    User getUserByEmail(String email);
}
