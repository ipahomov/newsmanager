package by.it.academy.dao;

import by.it.academy.model.User;
import by.it.academy.utils.DataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Operations with users table
 */
public class UserDao implements IUserDao {
    final static Logger logger = Logger.getLogger(UserDao.class);
    public static UserDao userDao;

    private UserDao() {
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    /**
     * Get user from DB by email (primary key)
     * @param email
     * @return user
     */
    public User getUserByEmail(String email) {
        Connection connection = DataSource.getInstance().getConnection();
        User user = null;
        String query = "SELECT * FROM user WHERE email=?";

        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, email);

            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setFirstName(result.getString(1));
                user.setLastName(result.getString(2));
                user.setEmail(result.getString(3));
                user.setPassword(result.getString(4));
            }

        } catch (SQLException e) {
            logger.error("Error get user by email", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return user;
    }

}
