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
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Category category = new Category();
                category.setCatId(resultSet.getString(1));
                category.setParentId(resultSet.getString(2));
                list.add(category);
            }
        } catch (SQLException e) {
            logger.error("Error get all categories", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return list;
    }

    public List<Category> getCategoriesByParentId(String parentId) {
        String query = "SELECT * FROM category WHERE parentId=" + "'" + parentId + "'";
        List<Category> list = new ArrayList<Category>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Category category = new Category();
                category.setCatId(resultSet.getString(1));
                category.setParentId(resultSet.getString(2));
                list.add(category);
            }

        } catch (SQLException e) {
            logger.error("Error get category by id", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return list;
    }

    public int addCategory(Category category) {
        String query = "INSERT INTO category VALUES (?,?)";
        int result = 0;
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, category.getCatId());
            pStatement.setString(2, category.getParentId());
            result = pStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error get add category", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return result;
    }

    public Category getCategory(String id) {
        String query = "SELECT * FROM category WHERE catId=?";
        Category category = new Category();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, id);
            ResultSet result = pStatement.executeQuery();

            if (result.next()) {
                category.setCatId(result.getString(1));
                category.setParentId(result.getString(2));
            }

        } catch (SQLException e) {
            logger.error("Error get category by id", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return category;
    }

    @Override
    public int deleteCategory(String catId) {
        String query = "DELETE FROM category WHERE catId=?";
        int result = 0;
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, catId);
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error delete category", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return result;

    }
}
