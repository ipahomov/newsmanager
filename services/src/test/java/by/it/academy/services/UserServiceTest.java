package by.it.academy.services;

import by.it.academy.model.User;
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
 * Created by IPahomov on 28.05.2016.
 */
@ContextConfiguration("/beans-TestServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserServiceTest {
    private final static Logger log = Logger.getLogger(UserServiceTest.class);
    private User user;

    @Autowired
    private IUserService userService;

    @Before
    public void prepareUser(){
        user = new User();
        user.setFirstName("FirstNameTestService");
        user.setLastName("LastNameTestService");
        user.setEmail("emailTestService@test.ru");
        user.setPassword("1111");
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        userService.save(user);
        log.info("Saved user by service method " + user);

        String email = "emailTestService@test.ru";
        User userTest = userService.getUserByEmail(email);
        assertNotNull(userTest);
        assertEquals("Equals:", email, userTest.getEmail());
        log.info("Saved user by service method " + userTest);
    }

    @Test
    public void testSave() throws Exception {
        Long id = userService.save(user);
        assertNotNull(id);
        assertNotNull(userService.get(User.class, id));
        log.info("Saved user by service method " + user + " with id: " + id);
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = userService.save(user);
        log.info("Saved user by service method " + user);

        User userTest = userService.get(User.class, id);
        userTest.setFirstName("UpdatedFirstNameService");
        userTest.setLastName("UpdatedLastNameService");
        userTest.setEmail("UpdatedEmailService@mail.ru");

        userService.update(userTest);
        User updatedUser = userService.get(User.class, id);
        log.info("Updated user by service method " + updatedUser);
        assertNotNull(updatedUser);
        assertEquals("Equals", "UpdatedFirstNameService", updatedUser.getFirstName());
    }

    @Test
    public void testGet() throws Exception {
        Long id = userService.save(user);
        log.info("Saved user by service method " + user);

        User userTest = userService.get(User.class, id);
        assertNotNull(userTest);
        log.info("Get user by service method " + user);
    }

    @Test
    public void testDelete() throws Exception {
        Long id = userService.save(user);
        log.info("Saved user by service method " + user);

        User userTest = userService.get(User.class, id);
        userService.delete(userTest);
        assertNull(userService.get(User.class, id));
    }
}