package by.it.academy.dao;

import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.News;
import by.it.academy.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by IPahomov on 03.05.2016.
 * Class implementing INewsDao interface and extends BaseDao.
 * Realizes all methods for operations with news table in database
 * Must be a singleton class.
 */
public class NewsDao extends BaseDao<News> implements INewsDao {
    final static Logger logger = Logger.getLogger(NewsDao.class);
    private static NewsDao newsDao;
    private static final String EDIT_NEWS_HQL = "UPDATE News n SET n.categoryName=:categoryName, n.title=:title," +
            " n.author=:author, n.annotation=:annotation, n.maintext=:maintext " +
            "WHERE n.newsId=:newsId ";

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


    /*public void editNews(News news) throws DaoException {
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            Query query = session.createQuery(EDIT_NEWS_HQL);
            query.setParameter("categoryName", news.getCategoryName());
            query.setParameter("categoryName", news.getCategoryName());
            query.setParameter("categoryName", news.getCategoryName());
            query.executeUpdate();
        } catch (HibernateException e) {
            logger.error("Error edit news " + e);
            throw new DaoException(e);
        }

    }*/

    public List<News> getAllNews() throws DaoException {
        Criteria criteria;
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            criteria = session.createCriteria(News.class);
        } catch (HibernateException e) {
            logger.error("Error get all news" + e);
            throw new DaoException(e);
        }

        return (List<News>) criteria.list();
    }

    public List<News> getNewsByCategory(String categoryName) throws DaoException {
        Criteria criteria;
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            criteria = session.createCriteria(News.class);
            criteria.add(Restrictions.eq("categoryName", categoryName));
        } catch (HibernateException e) {
            logger.error("Error get news by category " + e);
            throw new DaoException(e);
        }

        return (List<News>) criteria.list();
    }
}
