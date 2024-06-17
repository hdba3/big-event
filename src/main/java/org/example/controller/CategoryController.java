/**
 * @author 33319
 * @Description
 * @create 2024/6/16 21:42
 */
package org.example.controller;


import org.example.pojo.Category;
import org.example.pojo.Result;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //添加分类
    @PostMapping
    public Result insert(@RequestBody @Validated(Category.Insert.class) Category category) {
        categoryService.insert(category);
        return Result.success();
    }

    //查询分类列表
    @GetMapping
    public Result list() {
        List<Category> category = categoryService.list();
        return Result.success(category);
    }

    //查询分类详情
    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        return Result.success(categoryService.detail(id));
    }

    //更新分类
    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

    //删除分类
    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        categoryService.delete(id);
        return Result.success();
    }
}
