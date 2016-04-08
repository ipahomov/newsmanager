package by.it.academy.commands;

import by.it.academy.dao.DAO;
import by.it.academy.dao.NewsDAO;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditNewsCommand implements Command {
	final static Logger logger = Logger.getLogger(EditNewsCommand.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		DAO dao = NewsDAO.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("news", dao.getNews(id) );
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
