package by.it.academy.commands;

import by.it.academy.model.Category;
import by.it.academy.model.News;
import by.it.academy.services.CategoryService;
import by.it.academy.services.NewsService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This command getting all categories and news from db via newsService
 * and categoryService and show theirs on main menu page
 */
public class ShowMenuCommand implements Command {
	final static Logger logger = Logger.getLogger(ShowMenuCommand.class);


	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String menuPage = "/menu.jsp";
		CategoryService categoryService = CategoryService.getCategoryService();
		NewsService newsService = NewsService.getNewsService();

		List<Category> catList = categoryService.getCategoriesByParent("main");
		List<News> newsList = newsService.getAllNews();

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
