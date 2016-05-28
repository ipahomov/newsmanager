package by.it.academy.dao;

import by.it.academy.model.User;
import by.it.academy.model.UserDetail;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by IPahomov on 04.05.2016.
 */
@ContextConfiguration("/beans-TestDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDaoTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void testAddUser() throws Exception {

        User user = new User();
        user.setFirstName("FirstNameTest");
        user.setLastName("LastNameTest");
        user.setEmail("emailTest@test.ru");
        user.setPassword("4444");

        userDao.save(user);
    }

    @Test
    public void testAddUserWithDDetails() throws Exception {
        User user = new User();
        user.setFirstName("FirstNameTest3");
        user.setLastName("LastNameTest3");
        user.setPassword("44443");
        user.setEmail("emailTest3");

        UserDetail userDetail = new UserDetail();
        userDetail.setCountry("CountryTest3");
        userDetail.setCity("CityTest3");

        user.setUserDetail(userDetail);
        userDetail.setUser(user);

        userDao.save(user);
    }

    @Ignore
    @Test
    public void testAddUserWithDDetailsAndCategories() throws Exception {
        /*User user = new User();
        user.setEmail("emailTest5");
        user.setPassword("555");
        user.setFirstName("FirstNameTest5");
        user.setLastName("LastNameTest5");

        UserDetail userDetail = new UserDetail();
        userDetail.setCountry("CountryTest5");
        userDetail.setCity("CityTest5");

        CategoryDao categoryDao = CategoryDao.getCategoryDao();
        Set<Category> categories = new HashSet<Category>();
        Category category1 = categoryDao.get(1L);
        Category category2 = categoryDao.get(2L);
        categories.add(category1);
        categories.add(category2);

        category1.setUserDetail(userDetail);
        category2.setUserDetail(userDetail);
        userDetail.setCategories(categories);

        user.setUserDetail(userDetail);
        userDetail.setUser(user);

        userDao.save(user);*/
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        String email = "pahomov@gmail.com";
        User user = userDao.getUserByEmail(email);
        assertNotNull(user);
        assertEquals("Equals:",email, user.getEmail());

    }
}