package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;
}
