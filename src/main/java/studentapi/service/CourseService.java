package studentapi.service;

import studentapi.model.dto.CourseRequestDTO;
import studentapi.model.dto.CourseResponseDTO;
import java.util.List;

public interface CourseService {
    CourseResponseDTO addCourseToStudent(int studentId, CourseRequestDTO dto);
    List<CourseResponseDTO> getCoursesForStudent(int studentId);
    void deleteCourse(int courseId);
}