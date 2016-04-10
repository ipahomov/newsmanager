package by.it.academy.services;

import by.it.academy.model.Category;

import java.util.List;

/**
 *
 */
public interface ICategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(String id);

    int addCategory(Category category);

}
