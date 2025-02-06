package dev.starzynski.learnify.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "lessons")
public class Lesson {
    @Id
    private ObjectId id;

    private String title;
    private String description;
    private String videoLink;
    private String bannerImageLink;
    private String filesLink;

    @DBRef
    @JsonIgnoreProperties("lessons")
    final private Course course;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdAtDate;

    public Lesson(Course course) {
        this.id = new ObjectId();
        this.createdAtDate = new Date();
        this.course = course;
    }

    public ObjectId getId(){ return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getVideoLink() { return videoLink; }
    public void setVideoLink(String videoLink) { this.videoLink = videoLink; }

    public String getBannerImageLink() { return bannerImageLink; }
    public void setBannerImageLink(String bannerImageLink) { this.bannerImageLink = bannerImageLink; }

    public String getFilesLink() { return filesLink; }
    public void setFilesLink(String filesLink) { this.filesLink = filesLink; }

    private Course getCourse() { return course; }

    public Date getCreatedAtDate() { return createdAtDate; }
}
