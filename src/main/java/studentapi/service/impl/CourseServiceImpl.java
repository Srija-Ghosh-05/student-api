package studentapi.service.impl;

import studentapi.exception.StudentNotFoundException;
import studentapi.model.Course;
import studentapi.model.Student;
import studentapi.model.dto.CourseRequestDTO;
import studentapi.model.dto.CourseResponseDTO;
import studentapi.repository.CourseRepository;
import studentapi.repository.StudentRepository;
import studentapi.service.CourseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                             StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    private CourseResponseDTO toResponseDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(course.getId());
        dto.setCourseName(course.getCourseName());
        return dto;
    }

    @Override
    public CourseResponseDTO addCourseToStudent(int studentId, CourseRequestDTO dto) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));

        Course course = new Course();
        course.setCourseName(dto.getCourseName());
        course.setStudent(student);  // ← links course to student (sets foreign key)

        return toResponseDTO(courseRepository.save(course));
    }

    @Override
    public List<CourseResponseDTO> getCoursesForStudent(int studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));

        return courseRepository.findByStudentId(studentId)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCourse(int courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found with id: " + courseId);
        }
        courseRepository.deleteById(courseId);
    }
}