package by.it.academy.commands;

import by.it.academy.model.News;
import by.it.academy.services.INewsService;
import by.it.academy.services.NewsService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowNewsPageCommand implements Command {
	final static Logger logger = Logger.getLogger(ShowNewsPageCommand.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		INewsService newsService = NewsService.getNewsService();
		int id = Integer.parseInt(request.getParameter("id"));
		News news = newsService.getNews(id);

		request.setAttribute("news", news);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/news.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}

	}

}
