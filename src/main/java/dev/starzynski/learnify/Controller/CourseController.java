package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Model.Course;
import dev.starzynski.learnify.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/auth/course", consumes = {"multipart/form-data"})
    public ResponseEntity<Boolean> createCourse(@RequestPart String title, @RequestPart String description, @RequestPart String username, @RequestPart String categoryName, @RequestPart MultipartFile promotingVideo, @RequestPart MultipartFile thumbnail){
        return new ResponseEntity<Boolean> (courseService.createCourse(title, description, username, categoryName, promotingVideo, thumbnail), HttpStatus.CREATED);
    }

    @GetMapping("/public/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<List<Course>> (courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/public/course/{title}")
    public ResponseEntity<Course> getCourse(@PathVariable String title){
        return new ResponseEntity<Course> (courseService.getCourse(title), HttpStatus.OK);
    }
}
