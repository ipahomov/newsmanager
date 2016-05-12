package by.it.academy.dao;

import by.it.academy.model.UserDetail;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IPahomov on 12.05.2016.
 */
public class UserDetailDaoTest {
    UserDetailDao userDetailDao = UserDetailDao.getUserDetailsDao();

    @Test
    public void testSaveOrUpdate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        UserDetail userDetail = userDetailDao.get(1L);
        assertNotNull(userDetail);
    }

    @Test
    public void testDelete() throws Exception {
        userDetailDao.delete(userDetailDao.get(2L));
        assertNull(userDetailDao.get(2L));
    }

    @Test
    public void testSave() throws Exception {

    }
}