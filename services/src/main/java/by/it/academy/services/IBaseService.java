package by.it.academy.services;

import java.io.Serializable;

/**
 * BaseService interface contains all common operations (CRUD)
 * Created by IPahomov on 27.05.2016.
 */
public interface IBaseService<T, PK extends Serializable> {
    /**
     * Save object to database
     * @param t object for saving
     * @return primary key of saved object
     */
    PK save(T t);

    /**
     * Saving updated object to database
     * @param t object to update
     */
    void update(T t);

    /**
     * Get object from database by id.
     * @param id primary key
     * @return object
     */
    T get(Class clazz, PK id);

    /**
     * Delete object from database
     * @param t object to delete
     */
    void delete(T t);

}
