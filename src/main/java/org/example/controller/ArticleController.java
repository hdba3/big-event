/**
 * @author 33319
 * @Description
 * @create 2024/6/12 9:19
 */
package org.example.controller;


import org.example.pojo.Article;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
//    @GetMapping("/list")
//    //RequestHeader注解用于获取请求头中的信息
//    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
////        try {
////            Map<String, Object> claims = JwtUtil.parseToken(token);
////            return Result.success("登录成功");
////        } catch (Exception e) {
////            e.printStackTrace();
////            //设置返回的状态码为401
////            response.setStatus(401);
////            return Result.error("token无效");
////        }
//        return Result.success("登录成功");
//    }

    @Autowired
    private ArticleService articleService;

    //新增文章
    @PostMapping
    public Result insert(@RequestBody @Validated Article article) {
        articleService.insert(article);
        return Result.success();
    }

    //条件分页查询

    /**
     * @param pageNum    页码
     * @param pageSize   每页显示的条数
     * @param state      文章状态
     * @param categoryId 分类id
     * @RequestParam(required = false)表示可为空
     */
    @GetMapping
    public Result<PageBean<Article>> list(Integer pageNum, Integer pageSize, @RequestParam(required = false) String state, @RequestParam(required = false) Integer categoryId) {
        PageBean<Article> pb = articleService.list(pageNum, pageSize, state, categoryId);
        return Result.success(pb);
    }
}
