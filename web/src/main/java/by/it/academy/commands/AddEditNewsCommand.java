package by.it.academy.commands;

import by.it.academy.model.News;
import by.it.academy.model.User;
import by.it.academy.services.INewsService;
import by.it.academy.services.NewsService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Concrete command for adding new news or editing news.
 * Implementing Command interface.
 * If author add new news or edit them this class check authors input data.
 * If it is all ok - news can be added/edited in database.
 * Returned to SiteController after action.
 * If records was incorrect or empty - nothing will be added or edited.
 */
public class AddEditNewsCommand implements Command {
    final static Logger logger = Logger.getLogger(AddEditNewsCommand.class);

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        INewsService newsService = NewsService.getNewsService();

        // flag for run process after check users inputed data
        boolean isRun = true;
        String categoryId = request.getParameter("categoryId");
        if ((categoryId == null) || categoryId.isEmpty())
            isRun = false;
        String title = request.getParameter("title");
        if ((title == null) || title.isEmpty())
            isRun = false;
        String annotation = request.getParameter("annotation");
        if ((annotation == null) || annotation.isEmpty())
            isRun = false;
        String maintext = request.getParameter("maintext");
        if ((maintext == null) || maintext.isEmpty())
            isRun = false;

        // if data is correct and not empty
        if (isRun) {
            News news = new News();

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            news.setCategoryId(categoryId);
            news.setTitle(title);
            news.setAuthor(user.getLastName());
            news.setAnnotation(annotation);
            news.setMaintext(maintext);

            // get parameter 'id' for chose action: add or edit
            String id = request.getParameter("id");
            if ((id == null) || id.isEmpty()) {
                int n = newsService.addNews(news);
                if (n > 0)
                    logger.info("New news added: " + news.toString());
            } else {
                news.setId(Integer.parseInt(id));
                int n = newsService.editNews(news);
                if (n > 0)
                    logger.info("News edited: " + news.toString());
            }
        }

        try {
            response.sendRedirect("SiteController");
        } catch (IOException e) {
            logger.error("Error add: ", e);
        }

    }

}
