package by.it.academy.dao;

import by.it.academy.model.UserDetail;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by IPahomov on 12.05.2016.
 */
public class UserDetailDaoTest {
    @Autowired
    UserDetailDao userDetailDao;

    @Test
    public void testSaveOrUpdate() throws Exception {

    }

    @Ignore
    @Test
    public void testGet() throws Exception {
        UserDetail userDetail = userDetailDao.get(UserDetail.class,1L);
        assertNotNull(userDetail);
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        userDetailDao.delete(userDetailDao.get(UserDetail.class,2L));
        assertNull(userDetailDao.get(UserDetail.class,2L));
    }

    @Test
    public void testSave() throws Exception {

    }
}