package dev.starzynski.learnify.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "categories")
public class Category {
    @Id
    private ObjectId id;

    private String name;

    @DBRef
    @JsonIgnoreProperties("category")
    final private List<Course> courses;

    public Category() {
        this.id = new ObjectId();
        this.courses = new ArrayList<>();
    }

    public ObjectId getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Course> getCourses() { return courses; }
}
