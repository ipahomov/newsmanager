package by.it.academy.commands;

import by.it.academy.dao.DAO;
import by.it.academy.dao.NewsDAO;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteNewsCommand implements Command {
	final static Logger logger = Logger.getLogger(DeleteNewsCommand.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = NewsDAO.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		int res = dao.deleteNews(id);

		if (res > 0)
			logger.info("deleted news: id = " + id);
		else
			logger.error("deleted news: id = " + id);

		try {
			response.sendRedirect("SiteController");
		} catch (IOException e) {
			logger.error("delete news");
		}

	}

}
