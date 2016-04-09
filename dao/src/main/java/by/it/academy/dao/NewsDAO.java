package by.it.academy.dao;

import by.it.academy.model.Category;
import by.it.academy.model.News;
import by.it.academy.utils.DataSource;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO implements DAO {
	final static Logger logger = Logger.getLogger(NewsDAO.class);
	private Connection connection;
	public static NewsDAO instance;

	public static NewsDAO getInstance(){
		if(instance == null) {
			instance = new NewsDAO();
		}
		return instance;
	}

	private NewsDAO(){
		try {
			connection = DataSource.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public News getNews(int id) {
		News news = null;
		String query = "SELECT * FROM news WHERE id=?";
		PreparedStatement pStatement;
		ResultSet result;
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, id);
			result = pStatement.executeQuery();

			if (result.next()) {
				news = new News();
				news.setId(result.getInt(1));
				news.setCategoryId(result.getString(2));
				news.setTitle(result.getString(3));
				news.setAuthor(result.getString(4));
				news.setAnnotation(result.getString(5));
				news.setMaintext(result.getString(6));
				news.setReleaseDate(result.getString(7));
			}

		} catch (SQLException e) {
			logger.error("Error get news", e);
		}
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
        return news;
	}

	public int addNews(News news) {
		String query = "INSERT INTO news (categoryId, title, author, annotation, maintext) VALUES (?,?,?,?,?)";
		int result = 0;
		PreparedStatement pStatement;
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, news.getCategoryId());
			pStatement.setString(2, news.getTitle());
			pStatement.setString(3, news.getAuthor());
			pStatement.setString(4, news.getAnnotation());
			pStatement.setString(5, news.getMaintext());
			result = pStatement.executeUpdate();

		} catch (SQLException e) {
			logger.error("Error add news", e);
		}
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
		return result;
	}

	public int deleteNews(int id) {
		String query = "DELETE FROM news WHERE id=?";
		int result = 0;
		PreparedStatement pStatement;
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, id);
			result = pStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error delete news", e);
		}
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
		return result;
	}

	public int editNews(News news) {
		String query = "UPDATE news SET categoryId=?, title=?, author=?, annotation=?, maintext=? WHERE id=?";
		int result = 0;
		PreparedStatement pStatement;
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, news.getCategoryId());
			pStatement.setString(2, news.getTitle());
			pStatement.setString(3, news.getAuthor());
			pStatement.setString(4, news.getAnnotation());
			pStatement.setString(5, news.getMaintext());
			pStatement.setInt(6, news.getId());
			result = pStatement.executeUpdate();

		} catch (SQLException e) {
			logger.error("Error update news", e);
		}
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
		return result;
	}

	public List<News> getAllNews() {
        Connection connectiona = null;
        try {
            connectiona = DataSource.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<News> list = new ArrayList<News>();
		String query = "SELECT * FROM news";
		try {
			Statement st = connectiona.createStatement();
			ResultSet result = st.executeQuery(query);
			while (result.next()) {
				News news = new News();
				news.setId(result.getInt(1));
				news.setCategoryId(result.getString(2));
				news.setTitle(result.getString(3));
				news.setAuthor(result.getString(4));
				news.setAnnotation(result.getString(5));
				news.setMaintext(result.getString(6));
				news.setReleaseDate(result.getString(7));
				list.add(news);
			}
			result.close();
			st.close();
		} catch (SQLException e) {
			logger.error("Error get all news", e);
		}
        try {
            connectiona.close();
        } catch (SQLException e) {
            logger.error(e);
        }
		return list;
	}

	public List<News> getNewsByCategoryId(String category) {
		List<News> list = new ArrayList<News>();
		String query = "SELECT * FROM news WHERE categoryId=" + "'" + category + "'";
		try {
			Statement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				News news = new News();
				news.setId(result.getInt(1));
				news.setCategoryId(result.getString(2));
				news.setTitle(result.getString(3));
				news.setAuthor(result.getString(4));
				news.setAnnotation(result.getString(5));
				news.setMaintext(result.getString(6));
				news.setReleaseDate(result.getString(7));
				list.add(news);
			}
		} catch (SQLException e) {
			logger.error("Error get news by category", e);
		}
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
		return list;
	}

}
