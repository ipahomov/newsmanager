package by.it.academy.services.impl;

import by.it.academy.dao.IUserDao;
import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.user.User;
import by.it.academy.services.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class implementing IUserService interface
 * Realizes user operations.
 */
@Service("userService")
@Transactional
public class UserService extends BaseService<User, Long> implements IUserService {
    final static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    public User getUserByEmail(String email) {
        User user = null;
        try {
            user = userDao.getUserByEmail(email);
        } catch (DaoException e) {
            log.error("Error get User by email: " + e);
        }
        return user;
    }
}
