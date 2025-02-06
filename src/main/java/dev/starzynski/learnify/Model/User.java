package dev.starzynski.learnify.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "users")
public class User {
    @Id
    private Object id;

    private String username;
    private String email;
    private String password;
    private String role;

    //learning courses
    //creatingg courses

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdAtDate;

    public User() {
        this.id = new ObjectId();
        this.createdAtDate = new Date();
    }

    public Object getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole() { this.role = role; }

    public Date getCreatedAtDate() { return createdAtDate; }
}
