package com.example.controller;

import com.example.entity.Category;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getDetail(@PathVariable("id") Integer id) {
        Category category = categoryService.findById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

   @PostMapping("/save-cate")
    public ResponseEntity<Category> postCategory(@RequestBody Category category) {
        Category newCategory = categoryService.save(category);
       return new ResponseEntity<>(newCategory, HttpStatus.OK);
    }

    @PutMapping("/update-cate/{id}")
    public ResponseEntity<Category> putCategory(@RequestBody Category category, @PathVariable("id") Integer id) {
        category.setId(id);
        Category updatedCategory = categoryService.save(category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete-cate/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
