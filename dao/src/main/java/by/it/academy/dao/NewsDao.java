package by.it.academy.dao;

import by.it.academy.model.News;
import by.it.academy.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by IPahomov on 03.05.2016.
 * Class implementing INewsDao interface.
 * Realizes all methods for operations with news table in database
 * Must be a singleton class.
 *
 */
public class NewsDao extends BaseDao<News> implements INewsDao {
    final static Logger logger = Logger.getLogger(NewsDao.class);
    private static NewsDao newsDao;

    /**
     * Singleton pattern
     */
    private NewsDao() {
    }

    public static NewsDao getNewsDao() {
        if (newsDao == null) {
            newsDao = new NewsDao();
        }
        return newsDao;
    }


    public int editNews(News news) {
        String hql = "UPDATE News";
        return 0;
    }

    public List<News> getAllNews() {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        Criteria criteria = session.createCriteria(News.class);

        return (List<News>)criteria.list();
    }

    public List<News> getNewsByCategory(String categoryName) {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        Criteria criteria = session.createCriteria(News.class);
        criteria.add(Restrictions.eq("categoryName", categoryName));

        return (List<News>) criteria.list();
    }
}
