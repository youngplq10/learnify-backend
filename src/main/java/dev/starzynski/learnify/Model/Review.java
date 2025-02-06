package dev.starzynski.learnify.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "reviews")
public class Review {
    @Id
    private ObjectId id;

    @DBRef
    @JsonIgnoreProperties({"reviews", "learningCourses", "creatingCourses"})
    final private User creator;

    private Integer stars;

    private String body;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdAtDate;

    public Review(User creator) {
        this.id = new ObjectId();
        this.createdAtDate = new Date();
        this.creator = creator;
    }

    public ObjectId getId() { return id; }

    public User getCreator() { return creator; }

    public Integer getStars() { return stars; }
    public void setStars(Integer stars) { this.stars = stars; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public Date getCreatedAtDate() { return createdAtDate; }
}
