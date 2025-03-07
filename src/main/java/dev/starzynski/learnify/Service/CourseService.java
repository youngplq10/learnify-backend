package dev.starzynski.learnify.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.starzynski.learnify.Model.Category;
import dev.starzynski.learnify.Model.Course;
import dev.starzynski.learnify.Model.User;
import dev.starzynski.learnify.Repository.CategoryRepository;
import dev.starzynski.learnify.Repository.CourseRepository;
import dev.starzynski.learnify.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Value("${upload.directory}")
    public String uploadDirectory;

    public Boolean createCourse(String title, String description, String username, String categoryName, MultipartFile promotingVideo, MultipartFile thumbnail) {
        try{
            File directory = new File(uploadDirectory);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            Course course = new Course();
            course.setTitle(title);
            course.setDescription(description);

            Category category = categoryRepository.findByName(categoryName);
            User user = userRepository.findByUsername(username).orElseThrow();

            course.setCategory(category);
            course.setCreator(user);

            byte[] videoBytes = promotingVideo.getBytes();
            byte[] thumbnailBytes = thumbnail.getBytes();

            Path videoPath = Paths.get(uploadDirectory + course.getId() + promotingVideo.getOriginalFilename());
            Path thumbnailPath = Paths.get(uploadDirectory + course.getId() + thumbnail.getOriginalFilename());

            Files.write(videoPath, videoBytes);
            Files.write(thumbnailPath, thumbnailBytes);

            course.setVideoLink("/uploads/" + course.getId() + promotingVideo.getOriginalFilename());
            course.setBannerImageLink("/uploads/" + course.getId() + thumbnail.getOriginalFilename());

            courseRepository.insert(course);
            user.getCreatingCourses().add(course);
            userRepository.save(user);

            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(String title) {
        return courseRepository.findByTitleIgnoreCase(title);
    }
}
