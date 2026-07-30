package studentapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentapi.model.dto.CourseRequestDTO;
import studentapi.model.dto.CourseResponseDTO;
import studentapi.service.CourseService;
import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<CourseResponseDTO> addCourse(
            @PathVariable int studentId,
            @Valid @RequestBody CourseRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.addCourseToStudent(studentId, dto));
    }

    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<List<CourseResponseDTO>> getCourses(
            @PathVariable int studentId) {
        return ResponseEntity.ok(courseService.getCoursesForStudent(studentId));
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}