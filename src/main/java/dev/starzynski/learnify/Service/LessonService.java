package dev.starzynski.learnify.Service;

import dev.starzynski.learnify.Model.Course;
import dev.starzynski.learnify.Model.Lesson;
import dev.starzynski.learnify.Repository.CourseRepository;
import dev.starzynski.learnify.Repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Value("${upload.directory}")
    public String uploadDirectory;

    public Boolean createLesson(String courseTitle, String title, String description, MultipartFile promotingVideo, MultipartFile thumbnail) {
        try{
            Course course = courseRepository.findByTitleIgnoreCase(courseTitle);
            Lesson lesson = new Lesson(course);
            lesson.setTitle(title);
            lesson.setDescription(description);

            byte[] videoBytes = promotingVideo.getBytes();
            byte[] thumbnailBytes = thumbnail.getBytes();

            Path videoPath = Paths.get(uploadDirectory + course.getId() + promotingVideo.getOriginalFilename());
            Path thumbnailPath = Paths.get(uploadDirectory + course.getId() + thumbnail.getOriginalFilename());

            Files.write(videoPath, videoBytes);
            Files.write(thumbnailPath, thumbnailBytes);

            course.setVideoLink("/uploads/" + course.getId() + promotingVideo.getOriginalFilename());
            course.setBannerImageLink("/uploads/" + course.getId() + thumbnail.getOriginalFilename());

            course.getLessons().add(lesson);
            courseRepository.save(course);

            lessonRepository.insert(lesson);

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
