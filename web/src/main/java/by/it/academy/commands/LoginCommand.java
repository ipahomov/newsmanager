package by.it.academy.commands;

import by.it.academy.dao.IUserDao;
import by.it.academy.dao.UserDao;
import by.it.academy.model.User;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements Command {
	final static Logger logger = Logger.getLogger(LoginCommand.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		IUserDao dao = UserDao.getInstance();
		String page;

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if ((email != null) && (!email.isEmpty()) || (password != null) && (!password.isEmpty())) {
			User user = dao.getUserByEmail(email);
			if (user != null) {
				try {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("SiteController");
				} catch (IOException e) {
					logger.error(e);
				}

			} else {
				page = "/erroruser.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					logger.error(e);
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}

	}

}
