package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Model.Category;
import dev.starzynski.learnify.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/admin/category")
    public ResponseEntity<Boolean> createCategory(@RequestBody Category category){
        return new ResponseEntity<Boolean> (categoryService.createCategory(category), HttpStatus.CREATED);
    }
}
