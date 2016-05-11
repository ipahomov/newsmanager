package by.it.academy.commands;

import by.it.academy.services.NewsService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Concrete command implementing Command interface.
 * Class add news data to page for editing.
 */
public class EditNewsCommand implements Command {
	final static Logger logger = Logger.getLogger(EditNewsCommand.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		NewsService newsService = NewsService.getNewsService();
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("news", newsService.getNews(id) );
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}

	}

}
