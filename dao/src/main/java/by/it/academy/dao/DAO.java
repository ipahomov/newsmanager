package by.it.academy.dao;

import by.it.academy.model.Category;
import by.it.academy.model.News;
import by.it.academy.model.User;

import java.util.List;


public interface DAO {

	News getNews(int id);

	int addNews(News news);

	int deleteNews(int id);

	int editNews(News news);

	int addCat(Category category);

	List<News> getAllNews();

	User getUserByEmail(String email);

	List<User> getAllUsers();

	List<Category> getAllCategories();

	Category getCategoryById(String id);

	List<News> getNewsByCategoryId(String category);

}
