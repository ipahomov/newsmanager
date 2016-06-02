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
import java.util.List;

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

    /*@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("newslist", newsService.getAllNews());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "welcome";
    }*/

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
        //model.addAttribute("user", getPrincipal());
        model.addAttribute("newslist", newsService.getAllNews());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/adminmenu";
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String authorPage(ModelMap model) {
        //model.addAttribute("user", getPrincipal());
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
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((AuthUser)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    /*@RequestMapping(value = "/home/listnews", method = RequestMethod.GET)
    public String listRedirect(ModelMap model){
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "redirect:/home/listnews/1";
    }*/

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homeList(ModelMap model,
    @RequestParam(name = "page", defaultValue = "1") int page,
    @RequestParam(name = "newsPerPage", defaultValue = "2") int newsPerPage) {

        int newsFrom = (page-1)*newsPerPage;
        int quantity = newsService.getCountNews();
        int count = getCount(quantity, newsPerPage);
        List<News> newsList = newsService.getNewsPagination(newsFrom, newsPerPage);

        if (page == (count/newsPerPage+1)){
            return "redirect:/home/"+page;
        }

        model.addAttribute("newslist", newsList);
        model.addAttribute("count", count);
        model.put("currentPage", (newsFrom/newsPerPage) + 1);
        model.put("newsPerPage", newsPerPage);

        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "welcome";
    }

    public int getCount(int quantity, int newsPerPage) {
        int count = 0;
        if (quantity > 1){
            if (quantity%newsPerPage > 0) {
                count = ((quantity/newsPerPage) + 1);
            } else {
                count = (quantity/newsPerPage);
            }
        } else if (quantity == 1) {
            count = 1;
        }
        return count;
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
