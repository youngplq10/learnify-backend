package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @PostMapping("/auth/lesson/{courseTitle}")
    public ResponseEntity<Boolean> createLesson(@PathVariable String courseTitle, @RequestPart String title, @RequestPart String description, @RequestPart MultipartFile promotingVideo, @RequestPart MultipartFile thumbnail){
        return new ResponseEntity<Boolean> (lessonService.createLesson(courseTitle, title, description, promotingVideo, thumbnail), HttpStatus.CREATED);
    }

}
