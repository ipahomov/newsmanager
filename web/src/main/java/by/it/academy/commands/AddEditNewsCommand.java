package by.it.academy.commands;

import by.it.academy.dao.DAO;
import by.it.academy.dao.NewsDAO;
import by.it.academy.model.News;
import by.it.academy.model.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 
 * Add or Edit News
 *
 */
public class AddEditNewsCommand implements Command {
	final static Logger logger = Logger.getLogger(AddEditNewsCommand.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = NewsDAO.getInstance();

		boolean run = true;
		String categoryId = request.getParameter("categoryId");
		if ((categoryId == null) || categoryId.isEmpty())
			run = false;
		String title = request.getParameter("title");
		if ((title == null) || title.isEmpty())
			run = false;
		String annotation = request.getParameter("annotation");
		if ((annotation == null) || annotation.isEmpty())
			run = false;
		String maintext = request.getParameter("maintext");
		if ((maintext == null) || maintext.isEmpty())
			run = false;

		if (run) {
			News news = new News();

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			news.setCategoryId(categoryId);
			news.setTitle(title);
			news.setAuthor(user.getLastName());
			news.setAnnotation(annotation);
			news.setMaintext(maintext);

			String id = request.getParameter("id");
			if ((id == null) || id.isEmpty()) {
				int n = dao.addNews(news);
				if (n > 0)
					logger.info("New news added: "+ news.toString());
			} else {
				news.setId(Integer.parseInt(id));
				int n = dao.editNews(news);
				if (n > 0)
					logger.info("News edited: "+ news.toString());
			}
		}

		try {
			response.sendRedirect("SiteController");
		} catch (IOException e) {
			logger.error("Error add: ", e);
		}

	}

}
