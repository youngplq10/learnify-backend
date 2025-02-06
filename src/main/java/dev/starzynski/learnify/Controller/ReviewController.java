package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
}
