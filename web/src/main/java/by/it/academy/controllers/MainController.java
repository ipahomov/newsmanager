package by.it.academy.controllers;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
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

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("newslist", newsService.getAllNews());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "welcome";
    }

    @RequestMapping(value = "/shownews/{newsId}", method = RequestMethod.GET)
    public String getNewsDetail(@PathVariable("newsId") Long id, ModelMap model){
        model.addAttribute("news", newsService.get(News.class,id));
        return "newsdetail";
    }

    @RequestMapping(value = "/showByCategory/{categoryName}", method = RequestMethod.GET)
    public String getNewsByCategory(@PathVariable("categoryName") String name, ModelMap model){
        model.addAttribute("user", getPrincipal());
        model.addAttribute("newslist", newsService.getNewsByCategory(name));
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("newslist", newsService.getAllNews());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/adminmenu";
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String authorPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("newslist", newsService.getAllNews());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/adminmenu";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", "User with email " +  getPrincipal() + " not registered");
        return "accesdenied";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "signin";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/home";
    }
    private String getPrincipal(){
        String userData = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String email = ((UserDetails)principal).getUsername();
            userData = userService.getUserByEmail(email).getLastName();
        } else {
            userData = principal.toString();
        }
        return userData;
    }

    /*@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    private String getNewsPaginated(@RequestParam(value = "page")int page,
                                    @RequestParam(value = "countperpage") int countPerPage,
                                    ModelMap model){

        countPerPage = 2;
        int lastPage = newsService.getCountNews()/countPerPage;
        page=0;

        model.addAttribute("newslist", newsService.getNewsPagination(page, countPerPage));
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));

        return "welcome";
    }*/

}
