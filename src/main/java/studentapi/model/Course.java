package studentapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Course() {}

    // Getters
    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public Student getStudent() { return student; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setStudent(Student student) { this.student = student; }
}