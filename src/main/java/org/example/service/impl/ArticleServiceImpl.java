/**
 * @author 33319
 * @Description
 * @create 2024/6/17 20:56
 */
package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.ArticleMapper;
import org.example.pojo.Article;
import org.example.pojo.PageBean;
import org.example.service.ArticleService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, String state, Integer categoryId) {
        //1.创建PageBean对象
        PageBean<Article> pb = new PageBean<>();

        //开启分页查询 PageHelper.startPage(页码,每页显示的条数)
        PageHelper.startPage(pageNum, pageSize);

        //调用mapper层函数，通过userid文章状态和分类id查询文章
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        //Page用于将查询结果封装到Page对象中来将其分页
        List<Article> as = articleMapper.list(userid, state, categoryId);
        Page<Article> page = (Page<Article>) as;

        //将数据填充到PageBean对象中
        pb.setTotal(page.getTotal());
        pb.setItems(page.getResult());
        return pb;
    }
}
