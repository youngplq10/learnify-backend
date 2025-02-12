package dev.starzynski.learnify.Service;

import dev.starzynski.learnify.Model.Category;
import dev.starzynski.learnify.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Boolean createCategory(Category category) {
        try{
            categoryRepository.insert(category);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
