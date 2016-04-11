package by.it.academy.dao;

import by.it.academy.model.User;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Leckter on 11.04.2016.
 */
public class UserDaoTest {
    IUserDao userDao = UserDao.getUserDao();

    @Test
    public void testGetUserDao() throws Exception {
        IUserDao userDao1 = UserDao.getUserDao();
        assertEquals(userDao, userDao1);
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        String email = "pahomov@gmail.com";
        User user = userDao.getUserByEmail(email);
        assertEquals(email, user.getEmail());
    }
}