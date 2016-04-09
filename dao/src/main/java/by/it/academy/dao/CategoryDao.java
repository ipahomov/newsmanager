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
    public static CategoryDao instance;

    /**
     * Singleton pattern
     */
    private CategoryDao() {
    }

    public static CategoryDao getInstance() {
        if (instance == null) {
            instance = new CategoryDao();
        }
        return instance;
    }

    /**
     * get all categories from table
     *
     * @return List<Category>
     */
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<Category>();
        String query = "SELECT * FROM category";
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                Category category = new Category();
                category.setCatId(result.getString(1));
                category.setParentId(result.getString(2));
                list.add(category);
            }
        } catch (SQLException e) {
            logger.error("Error get all categories", e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
        return list;
    }

    /**
     * Get category from table by id
     *
     * @param id
     * @return category by id
     */
    public Category getCategoryById(String id) {
        Category cat = new Category();
        String query = "SELECT * FROM category WHERE catId=?";
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, id);
            ResultSet result = pStatement.executeQuery();

            if (result.next()) {
                cat = new Category();
                cat.setCatId(result.getString(1));
                cat.setParentId(result.getString(2));
            }

        } catch (SQLException e) {
            logger.error("Error get category by id", e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
        return cat;
    }

    /**
     * Add new Category
     *
     * @param category
     * @return affected rows (int)
     */
    public int addCat(Category category) {
        String query = "INSERT INTO category VALUES (?,?)";
        int result = 0;
        PreparedStatement pStatement;
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, category.getCatId());
            pStatement.setString(2, category.getParentId());
            result = pStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error get add category", e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
        return result;
    }
}
