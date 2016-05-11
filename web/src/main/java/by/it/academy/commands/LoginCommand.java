package by.it.academy.commands;

import by.it.academy.model.User;
import by.it.academy.services.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Login concrete command implementing Command interface
 * Command gets users parameters (email and password)
 * then check if such user exists through users table in database.
 * If users data corrects he can access to site main commands
 * such as add/edit/delete news or categories.
 * If users input data is incorrect he must relogin.
 */
public class LoginCommand implements Command {
    final static Logger logger = Logger.getLogger(LoginCommand.class);

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = UserService.getUserService();
        String page;

        // users input data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // if users data correct - send his data to session
        if ((email != null) && (!email.isEmpty()) || (password != null) && (!password.isEmpty())) {
            User user = userService.getUserByEmail(email);
            if ((user!=null)&&((user.getPassword()).equals(password))) {
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
        } else {
            try {
                response.sendRedirect("/login.jsp");
            } catch (IOException e) {
                logger.error(e);
            }
        }

    }

}
