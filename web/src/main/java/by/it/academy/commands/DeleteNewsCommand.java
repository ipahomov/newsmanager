package by.it.academy.commands;

import by.it.academy.services.INewsService;
import by.it.academy.services.NewsService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Deleting concrete command implementing Command interface
 * Command delete news by id and returned to SiteController
 */
public class DeleteNewsCommand implements Command {
    final static Logger logger = Logger.getLogger(DeleteNewsCommand.class);

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        INewsService newsService = NewsService.getNewsService();
        int id = Integer.parseInt(request.getParameter("id"));
        int res = newsService.deleteNews(id);

        if (res > 0)
            logger.info("deleted news: " + newsService.getNews(id));
        else
            logger.error("error delete news: " + newsService.getNews(id));

        try {
            response.sendRedirect("SiteController");
        } catch (IOException e) {
            logger.error("delete news");
        }

    }

}
