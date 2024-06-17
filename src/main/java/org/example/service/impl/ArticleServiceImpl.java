/**
 * @author 33319
 * @Description
 * @create 2024/6/17 20:56
 */
package org.example.service.impl;

import org.example.mapper.ArticleMapper;
import org.example.pojo.Article;
import org.example.service.ArticleService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void insert(Article article) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        article.setCreateUser(userid);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.insert(article);
    }
}
