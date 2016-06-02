package by.it.academy.services;

import by.it.academy.model.user.User;
import by.it.academy.model.user.UserDetail;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Tests for user details service
 * Created by IPahomov on 28.05.2016.
 */
@ContextConfiguration("/beans-TestServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDetailServiceTest {
    private final static Logger log = Logger.getLogger(UserDetailServiceTest.class);
    UserDetail userDetail;

    @Autowired
    private IUserDetailService userDetailService;

    @Before
    public void prepareUserDetail() {
        userDetail = new UserDetail();
        userDetail.setCountry("TestCountry");
        userDetail.setCity("TestCity");

        User user = new User();
        user.setFirstName("Firstnametest");
        user.setLastName("Lastnametest");
        user.setEmail("emailtest@test.ru");
        user.setPassword("44444444");

        userDetail.setUser(user);
    }

    @Test
    public void testSave() throws Exception {
        Long id = userDetailService.save(userDetail);
        assertNotNull(id);
        assertNotNull(userDetailService.get(UserDetail.class, id));
        log.info("Saved user details: " + userDetail);

    }

    @Test
    public void testGet() throws Exception {
        Long id = userDetailService.save(userDetail);
        UserDetail userDetailTest = userDetailService.get(UserDetail.class, id);
        assertNotNull(userDetailTest);
        log.info("Get user details: " + userDetail);
    }

    @Test
    public void testDelete() throws Exception {
        Long id = userDetailService.save(userDetail);
        UserDetail userDetailTest = userDetailService.get(UserDetail.class, id);

        userDetailService.delete(userDetailTest);
        assertNull("Deleted", userDetailService.get(UserDetail.class, id));
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = userDetailService.save(userDetail);
        UserDetail userDetailTest = userDetailService.get(UserDetail.class, id);

        userDetailTest.setCountry("UpdatedCountryTest");
        userDetailTest.setCity("UpdatedCityTest");
        userDetailService.update(userDetailTest);

        UserDetail userDetailUpdatedTest = userDetailService.get(UserDetail.class, id);
        log.info("Updated user details: " + userDetailUpdatedTest);
        assertNotNull(userDetailUpdatedTest);
        assertEquals("UpdatedCountryTest", userDetailUpdatedTest.getCountry());
    }
}