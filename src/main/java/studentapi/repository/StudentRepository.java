package studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import studentapi.model.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.marks > :marks")
    List<Student> findStudentsWithMarksGreaterThan(@Param("marks") int marks);

    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> findByNameContaining(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.marks BETWEEN :min AND :max")
    List<Student> findStudentsInMarksRange(@Param("min") int min, @Param("max") int max);
}