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

import static org.junit.Assert.*;

/**
 * Test for user details operations.
 * Created by IPahomov on 12.05.2016.
 */
@ContextConfiguration("/beans-TestDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDetailDaoTest {
    private final static Logger log = Logger.getLogger(UserDetailDaoTest.class);
    UserDetail userDetail;

    @Autowired
    private IUserDetailDao userDetailDao;

    @Before
    public void prepareUserDetail() {
        userDetail = new UserDetail();
        userDetail.setCountry("TestCountry");
        userDetail.setCity("TestCity");
        userDetail.setUser(new User());
    }

    @Test
    public void testSave() throws Exception {
        Long id = userDetailDao.save(userDetail);
        assertNotNull(id);
        assertNotNull(userDetailDao.get(UserDetail.class, id));
        log.info("Saved user details: " + userDetail);

    }

    @Test
    public void testGet() throws Exception {
        Long id = userDetailDao.save(userDetail);
        UserDetail userDetailTest = userDetailDao.get(UserDetail.class, id);
        assertNotNull(userDetailTest);
        log.info("Get user details: " + userDetail);
    }

    @Test
    public void testDelete() throws Exception {
        Long id = userDetailDao.save(userDetail);
        UserDetail userDetailTest = userDetailDao.get(UserDetail.class, id);

        userDetailDao.delete(userDetailTest);
        assertNull("Deleted", userDetailDao.get(UserDetail.class, id));
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = userDetailDao.save(userDetail);
        UserDetail userDetailTest = userDetailDao.get(UserDetail.class, id);

        userDetailTest.setCountry("UpdatedCountryTest");
        userDetailTest.setCity("UpdatedCityTest");
        userDetailDao.update(userDetailTest);

        UserDetail userDetailUpdatedTest = userDetailDao.get(UserDetail.class, id);
        log.info("Updated user details: " + userDetailUpdatedTest);
        assertNotNull(userDetailUpdatedTest);
        assertEquals("UpdatedCountryTest", userDetailUpdatedTest.getCountry());
    }
}