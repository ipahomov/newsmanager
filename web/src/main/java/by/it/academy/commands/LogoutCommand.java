package by.it.academy.commands;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IPahomov on 12.05.2016.
 */
public class LogoutCommand implements Command {
    final static Logger logger = Logger.getLogger(LogoutCommand.class);

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        try {
            response.sendRedirect("SiteController");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
