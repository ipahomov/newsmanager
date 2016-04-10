package by.it.academy.dao;

import by.it.academy.model.Category;
import by.it.academy.utils.DataSource;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Operations with categories table
 */
public class CategoryDao implements ICategoryDao {
    final static Logger logger = Logger.getLogger(UserDao.class);
    public static CategoryDao categoryDao;

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

    /**
     * get all categories from table
     *
     * @return List<Category>
     */
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<Category>();
        String query = "SELECT * FROM category";
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Category category = new Category();
                category.setCatId(result.getString(1));
                category.setParentId(result.getString(2));
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

    /**
     * Get category from table by id
     *
     * @param parentId
     * @return category by id
     */
    public List<Category> getCategoriesByParentId(String parentId) {
        List<Category> list = new ArrayList<Category>();
        String query = "SELECT * FROM category WHERE parentId=" + "'" + parentId + "'";
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Category category = new Category();
                category.setCatId(result.getString(1));
                category.setParentId(result.getString(2));
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

    /**
     * Add new Category
     *
     * @param category
     * @return affected rows (int)
     */
    public int addCategory(Category category) {
        String query = "INSERT INTO category VALUES (?,?)";
        int result = 0;
        PreparedStatement pStatement;
        Connection connection = DataSource.getInstance().getConnection();
        try {
            pStatement = connection.prepareStatement(query);
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
        Category category = new Category();
        String query = "SELECT * FROM category WHERE catId=?";
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
}
