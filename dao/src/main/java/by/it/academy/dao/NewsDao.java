package by.it.academy.dao;

import by.it.academy.model.News;
import by.it.academy.utils.DataSource;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing INewsDao interface.
 * Realizes all methods for operations with news table in database
 * Must be a singleton class.
 */
public class NewsDao implements INewsDao {
    final static Logger logger = Logger.getLogger(NewsDao.class);
    private static NewsDao newsDao;

    /**
     * Singleton pattern
     */
    private NewsDao() {
    }

    public static NewsDao getNewsDao() {
        if (newsDao == null) {
            newsDao = new NewsDao();
        }
        return newsDao;
    }

    public News getNews(int id) {
        String query = "SELECT * FROM news WHERE id=?";
        News news = new News();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            ResultSet resultSet = pStatement.executeQuery();

            if (resultSet.next()) {
                news.setId(resultSet.getInt(1));
                news.setCategoryId(resultSet.getString(2));
                news.setTitle(resultSet.getString(3));
                news.setAuthor(resultSet.getString(4));
                news.setAnnotation(resultSet.getString(5));
                news.setMaintext(resultSet.getString(6));
                news.setReleaseDate(resultSet.getString(7));
            }
        } catch (SQLException e) {
            logger.error("Error get news", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return news;
    }

    public int addNews(News news) {
        String query = "INSERT INTO news (categoryId, title, author, annotation, maintext) VALUES (?,?,?,?,?)";
        int result = 0;
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, news.getCategoryId());
            pStatement.setString(2, news.getTitle());
            pStatement.setString(3, news.getAuthor());
            pStatement.setString(4, news.getAnnotation());
            pStatement.setString(5, news.getMaintext());
            result = pStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error add news", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return result;
    }

    public int deleteNews(int id) {
        String query = "DELETE FROM news WHERE id=?";
        int result = 0;
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error delete news", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return result;
    }

    public int editNews(News news) {
        String query = "UPDATE news SET categoryId=?, title=?, author=?, annotation=?, maintext=? WHERE id=?";
        int result = 0;
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, news.getCategoryId());
            pStatement.setString(2, news.getTitle());
            pStatement.setString(3, news.getAuthor());
            pStatement.setString(4, news.getAnnotation());
            pStatement.setString(5, news.getMaintext());
            pStatement.setInt(6, news.getId());
            result = pStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error update news", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return result;
    }

    public List<News> getAllNews() {
        String query = "SELECT * FROM news ORDER BY id";
        List<News> list = new ArrayList<News>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setCategoryId(resultSet.getString(2));
                news.setTitle(resultSet.getString(3));
                news.setAuthor(resultSet.getString(4));
                news.setAnnotation(resultSet.getString(5));
                news.setMaintext(resultSet.getString(6));
                news.setReleaseDate(resultSet.getString(7));
                list.add(news);
            }
        } catch (SQLException e) {
            logger.error("Error get all news", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return list;
    }

    public List<News> getNewsByCategoryId(String category) {
        String query = "SELECT * FROM news WHERE categoryId=" + "'" + category + "'";
        List<News> list = new ArrayList<News>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setCategoryId(resultSet.getString(2));
                news.setTitle(resultSet.getString(3));
                news.setAuthor(resultSet.getString(4));
                news.setAnnotation(resultSet.getString(5));
                news.setMaintext(resultSet.getString(6));
                news.setReleaseDate(resultSet.getString(7));
                list.add(news);
            }
        } catch (SQLException e) {
            logger.error("Error get news by category", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }

        return list;
    }

}
