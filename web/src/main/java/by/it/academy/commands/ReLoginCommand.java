package by.it.academy.commands;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReLoginCommand implements Command {
	final static Logger logger = Logger.getLogger(ReLoginCommand.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("LoginController");
		} catch (IOException e) {
			logger.error(e);
		}

	}

}
