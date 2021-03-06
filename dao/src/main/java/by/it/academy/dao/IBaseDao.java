package by.it.academy.dao;


import by.it.academy.dao.exceptions.DaoException;

import java.io.Serializable;

/**
 * Interface for basic operations with any entities via database.
 * Throws Dao exceptions. Handled in service layer.
 * @param <T> object
 * @param <PK> primary key
 */
public interface IBaseDao<T, PK extends Serializable> {

    /**
     * Save object to database
     * @param t object for saving
     * @return PK primary key of saved object
     * @throws DaoException
     */
    PK save(T t) throws DaoException;

    /**
     * Saving updated object to database
     * @param t object to update
     * @throws DaoException
     */
    void update(T t) throws DaoException;

    /**
     * Get object from database by id.
     * @param clazz class of getting object
     * @param id primary key
     * @return object
     * @throws DaoException
     */
    T get(Class clazz, PK id) throws DaoException;

    /**
     * Delete object from database
     * @param t object to delete
     * @throws DaoException
     */
    void delete(T t) throws DaoException;
}


