package by.it.academy.dao.impl;


import by.it.academy.dao.IBaseDao;
import by.it.academy.dao.exceptions.DaoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Basic operations to any entities classes.
 * Implements Dao interface.
 * @param <T>
 */
@Repository
public class BaseDao<T, PK extends Serializable> implements IBaseDao<T, PK> {
    private SessionFactory sessionFactory;

    @Autowired
    public BaseDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public PK save(T t) throws DaoException {
        return (PK) getSession().save(t);
    }

    public void update(T t) throws DaoException {
        getSession().update(t);
    }

    public T get(Class clazz, PK id) throws DaoException {
        return (T) getSession().get(clazz, id);
    }

    public void delete(T t) throws DaoException {
        getSession().delete(t);
    }
}
