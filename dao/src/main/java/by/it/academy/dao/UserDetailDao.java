package by.it.academy.dao;

import by.it.academy.model.UserDetail;

/**
 * Created by IPahomov on 04.05.2016.
 */
public class UserDetailDao extends BaseDao<UserDetail> {

    private static UserDetailDao userDetailsDao;

    /**
     * Singleton pattern
     */
    private UserDetailDao() {
    }

    public static UserDetailDao getUserDetailsDao() {
        if (userDetailsDao == null) {
            userDetailsDao = new UserDetailDao();
        }
        return userDetailsDao;
    }
}
