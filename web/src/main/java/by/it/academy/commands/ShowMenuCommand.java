package by.it.academy.commands;

import by.it.academy.dao.CategoryDao;
import by.it.academy.dao.NewsDao;
import by.it.academy.model.Category;
import by.it.academy.model.News;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ShowMenuCommand implements Command {
	final static Logger logger = Logger.getLogger(ShowMenuCommand.class);


	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String menuPage = "/menu.jsp";

		List<Category> catList = CategoryDao.getInstance().getAllCategories();
		List<News> newsList = NewsDao.getInstance().getAllNews();

		request.setAttribute("categories", catList);
		request.setAttribute("allnews", newsList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(menuPage);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}

	}

}
