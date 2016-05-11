package by.it.academy.controllers;


import by.it.academy.model.News;
import by.it.academy.services.NewsService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListNews
 */
//@WebServlet("/ListNews")
public class ListNewsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    final static Logger logger = Logger.getLogger(ListNewsController.class);

    NewsService newsService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNewsController() {
        super();
        newsService = NewsService.getNewsService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = "";
        String action = request.getParameter("action");
        if (action == null) {
            page = "/listnews.jsp";
            List<News> listNews = newsService.getAllNews();
            request.setAttribute("listNews", listNews);
        } else if (action.equals("shownews")) {
            page = "/shownews.jsp";
            Long id = Long.parseLong(request.getParameter("id"));
            News news = null;
                news = newsService.getNews(id);
            request.setAttribute("news", news);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
