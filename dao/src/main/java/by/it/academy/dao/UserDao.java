package by.it.academy.dao;

import by.it.academy.model.User;
import by.it.academy.utils.DataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class implementing IUserDao interface.
 * Realizes all methods for operations with users table in database
 * Must be a singleton class.
 */
public class UserDao implements IUserDao {
    final static Logger logger = Logger.getLogger(UserDao.class);
    private static UserDao userDao;

    /**
     * Singleton pattern
     */
    private UserDao() {
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public User getUserByEmail(String email) {
        String query = "SELECT * FROM user WHERE email=?";
        User user = new User();
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;

        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, email);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                user.setFirstName(resultSet.getString(1));
                user.setLastName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
            }

        } catch (SQLException e) {
            logger.error("Error get user by email", e);
        } finally {
            DataSource.closeConnection(resultSet, pStatement, connection);
        }

        return user;
    }

}
