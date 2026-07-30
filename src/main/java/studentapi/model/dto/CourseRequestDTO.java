package studentapi.model.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseRequestDTO {

    @NotBlank(message = "Course name cannot be blank")
    private String courseName;

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
}