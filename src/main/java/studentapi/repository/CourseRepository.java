package studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentapi.model.Course;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByStudentId(int studentId);
}