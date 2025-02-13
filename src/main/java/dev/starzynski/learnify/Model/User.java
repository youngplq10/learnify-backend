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

@Document(collection = "users")
public class User {
    @Id
    private Object id;

    private String username;
    private String email;
    private String password;
    private String role;

    @DBRef
    @JsonIgnoreProperties("students")
    private List<Course> learningCourses;

    @DBRef
    @JsonIgnoreProperties("students")
    private List<Course> creatingCourses;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdAtDate;

    public User() {
        this.id = new ObjectId();
        this.createdAtDate = new Date();
        this.learningCourses = new ArrayList<>();
        this.creatingCourses = new ArrayList<>();
        this.role = "USER";
    }

    public Object getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }

    public List<Course> getLearningCourses() { return learningCourses; }
    public List<Course> getCreatingCourses() { return creatingCourses; }

    public Date getCreatedAtDate() { return createdAtDate; }
}
