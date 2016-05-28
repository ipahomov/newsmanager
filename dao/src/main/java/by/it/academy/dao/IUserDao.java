package by.it.academy.dao;

import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.User;

/**
 * interface for users
 */
public interface IUserDao extends IBaseDao<User, Long> {
    /**
     * This method return User from DB table by email(primary key)
     *
     * @param email - parameter of method
     * @return User user by email
     */
    User getUserByEmail(String email) throws DaoException;
}
