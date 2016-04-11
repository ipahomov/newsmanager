package by.it.academy.filtres;

import by.it.academy.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter for LoginServlet
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");*/
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute("user");
            if (user != null)
                chain.doFilter(request,response);
            else{
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect("/login.jsp");
            }

    }

    public void destroy() {

    }
}
