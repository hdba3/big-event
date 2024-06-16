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

    @PostMapping
    public Result insert(@RequestBody @Validated Category category) {
        categoryService.insert(category);
        return Result.success();
    }

    @Validated
    @GetMapping
    public Result list() {
        List<Category> category = categoryService.list();
        return Result.success(category);
    }
}
