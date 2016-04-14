package by.it.academy.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Pattern Command.
 * Each concrete commands implementing this interface.
 * Concrete commands use for manage users actions via main controller
 * (SiteController).
 */
public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
