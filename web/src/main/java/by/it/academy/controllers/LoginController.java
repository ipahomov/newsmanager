package by.it.academy.controllers;

import by.it.academy.commands.Command;
import by.it.academy.commands.LoginCommand;
import by.it.academy.commands.ShowLoginCommand;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class LoginController
 * Controller for users login operations
 */
//@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    final static Logger logger = Logger.getLogger(LoginController.class);


    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Command command = null;
        String action = request.getParameter("login");

        // show login page
        if (action == null) {
            command = new ShowLoginCommand();
        }

            command.execute(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // login to site through user login form
        new LoginCommand().execute(request, response);
    }

}
