package by.it.academy.controllers;

import by.it.academy.auth.AuthUser;
import by.it.academy.model.News;
import by.it.academy.services.ICategoryService;
import by.it.academy.services.INewsService;
import by.it.academy.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main controller for common actions, welcome page and login
 * Created by IPahomov on 29.05.2016.
 */
@Controller
public class MainController {

    @Autowired
    private INewsService newsService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IUserService userService;

    /**
     * Show news details on single page
     *
     * @param id    of news
     * @param model get details of news
     * @return single page with news
     */
    @RequestMapping(value = "/shownews/{newsId}", method = RequestMethod.GET)
    public String getNewsDetail(@PathVariable("newsId") Long id, ModelMap model) {
        model.addAttribute("news", newsService.get(News.class, id));
        return "newsdetail";
    }

    /**
     * Show news sorted by category name
     *
     * @param name  of category
     * @param model get news and categories lists
     * @return welcome page
     */
    @RequestMapping(value = "/showByCategory/{categoryName}", method = RequestMethod.GET)
    public String getNewsByCategory(@PathVariable("categoryName") String name, ModelMap model) {
        model.addAttribute("newslist", newsService.getNewsByCategory(name));
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "welcome";
    }

    /**
     * Go to admin main menu
     *
     * @param model get news and categories lists
     * @return admin main menu page through login
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("newslist", newsService.getAllNews());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/adminmenu";
    }

    /**
     * Go to admin main menu
     *
     * @param model get news and categories lists
     * @return admin main menu page through login
     */
    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String authorPage(ModelMap model) {
        model.addAttribute("newslist", newsService.getAllNews());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/adminmenu";
    }

    /**
     * Shows error page if access denied after login
     *
     * @param model get user data
     * @return error page
     */
    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", "User with email " + getPrincipal() + " not registered");
        return "accesdenied";
    }

    /**
     * Shows login form
     *
     * @return login page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "signin";
    }

    /**
     * User logout. Uses spring security logout, which invalidate session
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return redirect to welcome page
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/home";
    }

    /**
     * Shows welcome page with greeting info and paginated news.
     *
     * @param model       get news, categories lists and data for pagination news.
     * @param page        of showed news
     * @param newsPerPage for showing
     * @return welcome page
     */
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homeList(ModelMap model,
                           @RequestParam(name = "page", defaultValue = "1") int page,
                           @RequestParam(name = "newsPerPage", defaultValue = "2") int newsPerPage) {

        // start position
        int newsFrom = (page - 1) * newsPerPage;
        // count of all news
        int quantity = newsService.getCountNews();
        // count of showing news
        int count = getPagesCount(quantity, newsPerPage);

        model.addAttribute("newslist", newsService.getNewsPagination(newsFrom, newsPerPage));
        model.put("currentPage", (newsFrom / newsPerPage) + 1);
        model.put("newsPerPage", newsPerPage);
        model.addAttribute("count", count);
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));

        return "welcome";
    }

    /**
     * Calculate pages count for news
     *
     * @param quantity    count of all news
     * @param newsPerPage to show
     * @return int count
     */
    public int getPagesCount(int quantity, int newsPerPage) {
        int count = 0;
        if (quantity > 1) {
            if (quantity % newsPerPage > 0) {
                count = ((quantity / newsPerPage) + 1);
            } else {
                count = (quantity / newsPerPage);
            }
        } else if (quantity == 1) {
            count = 1;
        }
        return count;
    }

    /**
     * Get logined user data from security context.
     * Checks, if has roles to requested actions
     *
     * @return user data
     */
    private String getPrincipal() {
        String userData = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userData = ((AuthUser) principal).getUsername();
        } else {
            userData = principal.toString();
        }
        return userData;
    }

}
