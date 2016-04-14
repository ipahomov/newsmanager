package by.it.academy.dao;

import by.it.academy.model.Category;
import by.it.academy.utils.DataSource;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing ICaregoryDao interface.
 * Realizes all methods for operations with categories table in database
 * Must be a singleton class.
 */
public class CategoryDao implements ICategoryDao {
    final static Logger logger = Logger.getLogger(CategoryDao.class);
    private static CategoryDao categoryDao;

    /**
     * Singleton pattern
     */
    private CategoryDao() {
    }

    public static CategoryDao getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new CategoryDao();
        }
        return categoryDao;
    }

    public List<Category> getAllCategories() {
        String query = "SELECT * FROM category";
        List<Category> list = new ArrayList<Category>();
        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Category category = new Category();
                category.setCatId(resultSet.getString(1));
                category.setParentId(resultSet.getString(2));
                list.add(category);
            }
        } catch (SQLException e) {
            logger.error("Error get all categories", e);
        } finally {
            DataSource.closeConnection(resultSet, statement, connection);
        }

        return list;
    }

    public List<Category> getCategoriesByParentId(String parentId) {
        String query = "SELECT * FROM category WHERE parentId=" + "'" + parentId + "'";
        List<Category> list = new ArrayList<Category>();
        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Category category = new Category();
                category.setCatId(resultSet.getString(1));
                category.setParentId(resultSet.getString(2));
                list.add(category);
            }

        } catch (SQLException e) {
            logger.error("Error get category by id", e);
        } finally {
            DataSource.closeConnection(resultSet, statement, connection);
        }

        return list;
    }

    public int addCategory(Category category) {
        String query = "INSERT INTO category VALUES (?,?)";
        int result = 0;
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, category.getCatId());
            pStatement.setString(2, category.getParentId());
            result = pStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error get add category", e);
        } finally {
            DataSource.closeConnection(null, pStatement, connection);
        }

        return result;
    }

    public Category getCategory(String id) {
        String query = "SELECT * FROM category WHERE catId=?";
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        Category category = new Category();

        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, id);
            resultSet = pStatement.executeQuery();

            if (resultSet.next()) {
                category.setCatId(resultSet.getString(1));
                category.setParentId(resultSet.getString(2));
            }

        } catch (SQLException e) {
            logger.error("Error get category by id", e);
        } finally {
            DataSource.closeConnection(resultSet, pStatement, connection);
        }

        return category;
    }

    public int deleteCategory(String catId) {
        String query = "DELETE FROM category WHERE catId=?";
        int result = 0;
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, catId);
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error delete category", e);
        } finally {
            DataSource.closeConnection(null, pStatement, connection);
        }

        return result;

    }
}
