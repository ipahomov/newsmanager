package by.it.academy.controllers;

import by.it.academy.model.News;
import by.it.academy.services.ICategoryService;
import by.it.academy.services.INewsService;
import by.it.academy.services.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IPahomov on 29.05.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private INewsService newsService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/showByCategory/{categoryName}", method = RequestMethod.GET)
    public String getNewsByCategory(@PathVariable("categoryName") String name, ModelMap model){
        model.addAttribute("newslist", newsService.getNewsByCategory(name));
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/adminmenu";
    }

    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public String addEditPage(ModelMap model){
        model.addAttribute("news", new News());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/addEdit";
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public String addNews(@ModelAttribute("news") News news){

        if(news.getNewsId() == null){
            news.setAuthor(getPrincipal());
            this.newsService.save(news);
        }
        else {
            this.newsService.update(news);
        }
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deletenews/{newsId}")
    public String deleteNews(@PathVariable("newsId") Long newsId){
        News news = newsService.get(News.class, newsId);
        this.newsService.delete(news);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/editNews/{newsId}", method = RequestMethod.GET)
    public String editNews(@PathVariable("newsId") Long id, ModelMap model){
        model.addAttribute("news", newsService.get(News.class, id));
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/addEdit";
    }

    @RequestMapping(value = "/shownews/{newsId}", method = RequestMethod.GET)
    public String getNewsDetail(@PathVariable("newsId") Long id, ModelMap model){
        model.addAttribute("news", newsService.get(News.class,id));
        return "admin/newsdetail";
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



}
