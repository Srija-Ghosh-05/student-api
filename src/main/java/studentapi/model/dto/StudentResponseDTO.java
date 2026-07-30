package studentapi.model.dto;

import java.util.List;

public class StudentResponseDTO {

    private int id;
    private String name;
    private String rollNumber;
    private int marks;
    private List<CourseResponseDTO> courses;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public int getMarks() { return marks; }
    public List<CourseResponseDTO> getCourses() { return courses; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    public void setMarks(int marks) { this.marks = marks; }
    public void setCourses(List<CourseResponseDTO> courses) { this.courses = courses; }
}