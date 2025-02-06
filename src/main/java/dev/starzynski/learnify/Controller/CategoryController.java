package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
}
