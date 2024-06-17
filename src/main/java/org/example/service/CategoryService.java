package org.example.service;

import org.example.pojo.Category;

import java.util.List;

public interface CategoryService {

    void insert(Category category);

    List<Category> list();

    Category detail(Integer id);

    void update(Category category);

    void delete(Integer id);
}
