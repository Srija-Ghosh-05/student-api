package studentapi.model.dto;

public class CourseResponseDTO {

    private int id;
    private String courseName;

    public int getId() { return id; }
    public String getCourseName() { return courseName; }

    public void setId(int id) { this.id = id; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
}