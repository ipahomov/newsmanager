package by.it.academy.commands;

import by.it.academy.dao.DAO;
import by.it.academy.dao.NewsDAO;
import by.it.academy.model.Category;
import by.it.academy.model.News;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowNewsByCategory implements Command {
	final static Logger logger = Logger.getLogger(ShowNewsByCategory.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = NewsDAO.getInstance();
		String menuPage = "/menu.jsp";

		List<Category> catList = dao.getAllCategories();
		String category = request.getParameter("catId");
		List<News> newsList = dao.getNewsByCategoryId(category);

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
