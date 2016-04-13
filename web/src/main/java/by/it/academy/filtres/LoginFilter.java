package by.it.academy.filtres;

import by.it.academy.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter for LoginServlet
 * User must be login to do main operations such as add/delete/edit news or categories.
 * Filter watches for login. If users data is correct, he can access to main operations.
 * If not - he will be redirecting to login page.
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Filter watches for users login. If he login correct - he will be in session.
     * Login servlet check users input data through form. If it corrects - users data
     * sending to session.
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null)
            chain.doFilter(request, response);
        else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/login.jsp");
        }

    }

    public void destroy() {
    }
}
