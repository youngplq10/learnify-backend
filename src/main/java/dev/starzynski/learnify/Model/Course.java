package dev.starzynski.learnify.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "courses")
public class Course {
    @Id
    private ObjectId id;

    @DBRef
    @JsonIgnoreProperties({"learningCourses", "creatingCourses"})
    private User creator;

    private String title;
    private String description;
    private String videoLink;
    private String bannerImageLink;

    @DBRef
    @JsonIgnoreProperties("course")
    final private List<Lesson> lessons;
    @DBRef
    final private List<Review> reviews;

    @DBRef
    @JsonIgnoreProperties({"learningCourses", "creatingCourses"})
    private List<User> students;

    @DBRef
    @JsonIgnoreProperties("courses")
    private Category category;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdAtDate;

    public Course() {
        this.id = new ObjectId();
        this.createdAtDate = new Date();
        this.lessons = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public ObjectId getId() { return id; }

    public User getCreator() { return creator; }
    public void setCreator(User creator) { this.creator = creator; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getVideoLink() { return videoLink; }
    public void setVideoLink(String videoLink) { this.videoLink = videoLink; }

    public String getBannerImageLink() { return bannerImageLink; }
    public void setBannerImageLink(String bannerImageLink) { this.bannerImageLink = bannerImageLink; }

    public Date getCreatedAtDate() { return createdAtDate; }

    public List<Lesson> getLessons() { return lessons; }
    public List<Review> getReviews() { return reviews; }

    public List<User> getStudents() { return students; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
