package org.example.service;

import org.example.pojo.Category;

import java.util.List;

public interface CategoryService {

    void insert(Category category);

    List<Category> list();
}
