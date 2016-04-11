package by.it.academy.controllers;

import by.it.academy.commands.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SiteController
 * Controller for authors/admin operations.
 * Operations is available if user registered as a author or admin.
 * So before each action user is checked in session.
 * Else - redirecting to LoginController via ReLogin command
 */
//@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public SiteController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Command command = null;

        String action = request.getParameter("action");
            if (action == null) {
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

        //execute command of chosen action
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
