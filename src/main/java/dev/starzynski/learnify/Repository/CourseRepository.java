package dev.starzynski.learnify.Repository;

import dev.starzynski.learnify.Model.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, ObjectId> {
    Course findByTitleIgnoreCase(String title);
}
