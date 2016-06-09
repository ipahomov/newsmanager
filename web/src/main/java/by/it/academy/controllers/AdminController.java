package by.it.academy.controllers;

import by.it.academy.auth.AuthUser;
import by.it.academy.model.News;
import by.it.academy.services.ICategoryService;
import by.it.academy.services.INewsService;
import by.it.academy.services.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Controller for admin operations
 * Access for all actions
 * Created by IPahomov on 29.05.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private static final Logger log = Logger.getLogger(AdminController.class);

    @Autowired
    private INewsService newsService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IUserService userService;

    /**
     * Show news sorted by category name
     *
     * @param name  of category
     * @param model get news and categories lists
     * @return admin main page
     */
    @RequestMapping(value = "/showByCategory/{categoryName}", method = RequestMethod.GET)
    public String getNewsByCategory(@PathVariable("categoryName") String name, ModelMap model) {
        model.addAttribute("newslist", newsService.getNewsByCategory(name));
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/adminmenu";
    }

    /**
     * Page for add or edit news
     *
     * @param model get new news and categories list
     * @return addEdit page
     */
    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public String addEditPage(ModelMap model) {
        model.addAttribute("news", new News());
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/addEdit";
    }

    /**
     * Adding or updating validated news. Show errors on page.
     *
     * @param news   for add or update
     * @param result check valid requirements
     * @param model  get categories list again if not validated news
     * @return admin main page
     */
    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public String addNews(@Valid @ModelAttribute("news") News news, BindingResult result, ModelMap model) {

        if (!result.hasErrors()) {
            if (news != null) {
                news.setAuthor(currentUserLastName());

                // save or update news
                if (news.getNewsId() == null) {
                    this.newsService.save(news);
                } else {
                    this.newsService.update(news);
                }
            }
        } else {
            model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
            return "admin/addEdit";
        }

        return "redirect:/admin";
    }

    /**
     * Delete chosen news
     *
     * @param newsId of news
     * @return admin main page
     */
    @RequestMapping(value = "/deleteNews/{newsId}")
    public String deleteNews(@PathVariable("newsId") Long newsId) {
        News news = newsService.get(News.class, newsId);
        this.newsService.delete(news);
        return "redirect:/admin";
    }

    /**
     * Prepare to edit chosen news.
     *
     * @param id    of editting news
     * @param model get existing data of news
     * @return addEdit page
     */
    @RequestMapping(value = "/editNews/{newsId}", method = RequestMethod.GET)
    public String editNews(@PathVariable("newsId") Long id, ModelMap model) {
        model.addAttribute("news", newsService.get(News.class, id));
        model.addAttribute("categories", categoryService.getCategoriesByParent("main"));
        return "admin/addEdit";
    }

    /**
     * Show news details on single page with options
     *
     * @param id    of news
     * @param model get details of news
     * @return single page with news
     */
    @RequestMapping(value = "/shownews/{newsId}", method = RequestMethod.GET)
    public String getNewsDetail(@PathVariable("newsId") Long id, ModelMap model) {
        model.addAttribute("news", newsService.get(News.class, id));
        return "admin/newsdetail";
    }

    /**
     * Get last name of current admin/author to save it to news details
     *
     * @return String lastname
     */
    public String currentUserLastName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((AuthUser) principal).getLastname();
    }

}
