package by.it.academy.dao;

import by.it.academy.dao.exceptions.DaoException;
import by.it.academy.model.News;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IPahomov on 03.05.2016.
 * Class implementing INewsDao interface and extends BaseDao.
 * Realizes all methods for operations with news table in database
 * Must be a singleton class.
 */
@Repository("newsDao")
public class NewsDao extends BaseDao<News, Long> implements INewsDao {
    final static Logger logger = Logger.getLogger(NewsDao.class);
    private static final String EDIT_NEWS_HQL = "UPDATE News n SET n.categoryName=:categoryName, n.title=:title," +
            " n.author=:author, n.annotation=:annotation, n.maintext=:maintext " +
            "WHERE n.newsId=:newsId ";

    @Autowired
    public NewsDao(SessionFactory sessionFactory) {
        super(sessionFactory);
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
            criteria = getSession().createCriteria(News.class);
            return criteria.list();
        } catch (HibernateException e) {
            logger.error("Error get all news" + e);
            throw new DaoException(e);
        }

    }

    public List<News> getNewsByCategory(String categoryName) throws DaoException {
        Criteria criteria;
        try {
            criteria = getSession().createCriteria(News.class);
            criteria.add(Restrictions.eq("categoryName", categoryName));
        } catch (HibernateException e) {
            logger.error("Error get news by category " + e);
            throw new DaoException(e);
        }

        return (List<News>) criteria.list();
    }
}
