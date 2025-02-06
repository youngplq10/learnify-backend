package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
}
