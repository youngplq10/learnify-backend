package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Model.Course;
import dev.starzynski.learnify.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/auth/course", consumes = {"multipart/form-data"})
    public ResponseEntity<Boolean> createCourse(@RequestPart String courseJSON, @RequestPart String username, @RequestPart String categoryName, @RequestPart MultipartFile promotingVideo, @RequestPart MultipartFile thumbnail){
        return new ResponseEntity<Boolean> (courseService.createCourse(courseJSON, username, categoryName, promotingVideo, thumbnail), HttpStatus.CREATED);
    }
}
