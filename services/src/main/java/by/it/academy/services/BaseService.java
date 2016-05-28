package by.it.academy.services;

import by.it.academy.dao.IBaseDao;
import by.it.academy.dao.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by IPahomov on 28.05.2016.
 */
@Service
@Transactional
public class BaseService<T, PK extends Serializable> implements IBaseService<T, PK> {
    private final static Logger log = Logger.getLogger(BaseService.class);

    @Autowired
    private IBaseDao<T,PK> baseDao;

    public BaseService(){}

    public PK save(T t) {
        PK pk = null;
        try {
            pk = baseDao.save(t);
        } catch (DaoException e) {
            log.error("Error save: " + e);
        }
        return pk;
    }

    public void update(T t) {
        try {
            baseDao.update(t);
        } catch (DaoException e) {
            log.error("Error update: " + e);
        }

    }

    public T get(Class clazz, PK id) {
        T t = null;
        try {
            t = baseDao.get(clazz, id);
        } catch (DaoException e) {
            log.error("Error get: " + e);
        }
        return t;
    }

    public void delete(T t) {
        try {
            baseDao.delete(t);
        } catch (DaoException e) {
            log.error("Error delete: " + e);
        }
    }
}
