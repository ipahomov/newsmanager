package by.it.academy.commands;

import by.it.academy.model.Category;
import by.it.academy.model.News;
import by.it.academy.services.CategoryService;
import by.it.academy.services.ICategoryService;
import by.it.academy.services.INewsService;
import by.it.academy.services.NewsService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Concrete command for getting all news by common category.
 * Implementing Command interface.
 *
 */
public class ShowNewsByCategory implements Command {
	final static Logger logger = Logger.getLogger(ShowNewsByCategory.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String menuPage = "/menu.jsp";

		ICategoryService categoryService = CategoryService.getCategoryService();
		INewsService newsService = NewsService.getNewsService();

		List<Category> catList = categoryService.getCategoriesByParentId("main");

		// getting name of category
		String category = request.getParameter("catId");
		List<News> newsList = newsService.getNewsByCategoryId(category);

		// send news
		request.setAttribute("categories", catList);
		request.setAttribute("allnews", newsList);

		// return to main page
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
