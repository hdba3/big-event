package org.example.service;

import org.example.pojo.Article;
import org.example.pojo.PageBean;

public interface ArticleService {

    void insert(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, String state, Integer categoryId);

    void update(Article article);

    void delete(Integer id);

    Article detail(Integer id);
}
