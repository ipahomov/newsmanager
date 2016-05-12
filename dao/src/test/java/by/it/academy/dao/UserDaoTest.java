package by.it.academy.dao;

import by.it.academy.model.Category;
import by.it.academy.model.User;
import by.it.academy.model.UserDetail;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.*;

/**
 * Created by IPahomov on 04.05.2016.
 */
public class UserDaoTest {
    UserDao userDao = UserDao.getUserDao();

    @Test
    public void testAddUser() throws Exception {

        /*User user = new User();
        user.setFirstName("FirstNameTest");
        user.setLastName("LastNameTest");
        user.setEmail("emailTest@test.ru");
        user.setPassword("4444");*/

        User user = new User();
        user.setFirstName("Igor");
        user.setLastName("Pahomov");
        user.setEmail("pahomov@gmail.com");
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

        //UserDetailDaoHiber userDetailDaoHiber = new UserDetailDaoHiber();
        UserDetail userDetail = new UserDetail();
        userDetail.setCountry("CountryTest3");
        userDetail.setCity("CityTest3");

        user.setUserDetail(userDetail);
        userDetail.setUser(user);

        userDao.save(user);
    }

    @Test
    public void testGetUser() throws Exception {
        System.out.println(userDao.get(2L));
    }

    @Test
    public void testAddUserWithDDetailsAndCategories() throws Exception {
        User user = new User();
        user.setEmail("emailTest5");
        user.setPassword("555");
        user.setFirstName("FirstNameTest5");
        user.setLastName("LastNameTest5");

        //UserDetailDaoHiber userDetailDaoHiber = new UserDetailDaoHiber();
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

        userDao.save(user);
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        String email = "emailTest5";
        User user = userDao.getUserByEmail(email);
        assertNotNull(user);
        assertEquals("Equals:",email, user.getEmail());

    }
}