package by.it.academy.services;

import by.it.academy.model.User;

/**
 * interface for user service
 */
public interface IUserService {

    /**
     * Getting user from table through dao module
     *
     * @param email of getting user
     * @return User user
     */
    User getUserByEmail(String email);
}
