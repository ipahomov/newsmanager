package by.it.academy.services;

import by.it.academy.dao.IUserDao;
import by.it.academy.dao.UserDao;
import by.it.academy.model.User;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Test for users services layer
 */
public class UserServiceTest {
    IUserService userService = UserService.getUserService();
    IUserDao userDao = UserDao.getUserDao();

    @Test
    public void testGetUserService() throws Exception {
        assertEquals(userService, UserService.getUserService());
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        String email = "pahomov@gmail.com";
        User user = userDao.getUserByEmail(email);
        assertEquals(user, userService.getUserByEmail(email));
    }
}