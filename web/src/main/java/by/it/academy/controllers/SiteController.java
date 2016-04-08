package by.it.academy.controllers;

import by.it.academy.commands.*;
import by.it.academy.dao.DAO;
import by.it.academy.dao.NewsDAO;
import by.it.academy.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Servlet implementation class SiteController
 */
@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DAO dao;

    /**
     * Default constructor.
     */
    public SiteController() {
        super();
        dao = NewsDAO.getInstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Command command = null;
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            if (action == null) {
                command = new ShowMenuCommand();
            } else if (action.equals("mainmenu")) {
                command = new ShowMenuCommand();
            } else if (action.equals("addnewsPage")) {
                command = new ShowAddPageCommand();
            } else if (action.equals("addnews")) {
                command = new AddEditNewsCommand();
            } else if (action.equals("shownews")) {
                command = new ShowNewsPageCommand();
            } else if (action.equals("deletenews")) {
                command = new DeleteNewsCommand();
            } else if (action.equals("editnews")) {
                command = new EditNewsCommand();
            } else if (action.equals("showbycat")) {
                command = new ShowNewsByCategory();
            }

        } else
            command = new ReLoginCommand();

        command.execute(request, response);

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
