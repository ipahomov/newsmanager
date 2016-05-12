package by.it.academy.dao;


import by.it.academy.dao.exceptions.DaoException;

import java.io.Serializable;

/**
 * Interface for basic operations with any entities via database.
 * @param <T>
 */
public interface Dao<T> {
    void saveOrUpdate(T t) throws DaoException;

    void save(T t) throws DaoException;

    T get(Serializable id) throws DaoException;

    T load(Serializable id) throws DaoException;

    void delete(T t) throws DaoException;
}




