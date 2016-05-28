package by.it.academy.dao;

import by.it.academy.model.User;
import by.it.academy.model.UserDetail;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.*;

/**
 * Test user operations.
 * Created by IPahomov on 04.05.2016.
 */
@ContextConfiguration("/beans-TestDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDaoTest {
    private final static Logger log = Logger.getLogger(UserDaoTest.class);
    private User user;

    @Autowired
    private IUserDao userDao;

    @Before
    public void prepareUser() {
        user = new User();
        user.setFirstName("FirstNameTest");
        user.setLastName("LastNameTest");
        user.setEmail("emailTest@test.ru");
        user.setPassword("4444");
    }

    @Test
    public void testAddUser() throws Exception {
        Long id = userDao.save(user);
        assertNotNull(id);
        assertNotNull(userDao.get(User.class, id));
        log.info("Saved user " + user + " with id: " + id);
    }

    @Test
    public void testAddUserWithDetails() throws Exception {

        UserDetail userDetail = new UserDetail();
        userDetail.setCountry("CountryTest");
        userDetail.setCity("CityTest");

        user.setUserDetail(userDetail);
        userDetail.setUser(user);

        userDao.save(user);
        log.info("Saved user " + user);
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        userDao.save(user);
        log.info("Saved user " + user);

        String email = "emailTest@test.ru";
        User userTest = userDao.getUserByEmail(email);
        assertNotNull(userTest);
        assertEquals("Equals:", email, userTest.getEmail());
        log.info("Saved user " + userTest);
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = userDao.save(user);
        log.info("Saved user " + user);

        User userTest = userDao.get(User.class, id);
        userTest.setFirstName("UpdatedFirstName");
        userTest.setLastName("UpdatedLastName");
        userTest.setEmail("UpdatedEmail@mail.ru");

        userDao.update(userTest);
        User updatedUser = userDao.get(User.class, id);
        log.info("Updated user " + updatedUser);
        assertNotNull(updatedUser);
        assertEquals("Equals", "UpdatedFirstName", updatedUser.getFirstName());

    }

    @Test
    public void testGet() throws Exception {
        Long id = userDao.save(user);
        log.info("Saved user " + user);

        User userTest = userDao.get(User.class, id);
        assertNotNull(userTest);
        log.info("Get user " + user);
    }

    @Test
    public void testDelete() throws Exception {
        Long id = userDao.save(user);
        log.info("Saved user " + user);

        User userTest = userDao.get(User.class, id);
        userDao.delete(userTest);
        assertNull(userDao.get(User.class, id));
    }
}