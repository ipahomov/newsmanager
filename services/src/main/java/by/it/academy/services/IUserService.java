package by.it.academy.services;

import by.it.academy.model.user.User;

/**
 * Interface for user service
 */
public interface IUserService extends IBaseService<User, Long> {

    /**
     * Getting user from table through dao module
     *
     * @param email of getting user
     * @return User user
     */
    User getUserByEmail(String email);
}
