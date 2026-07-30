package studentapi.service.impl;

import studentapi.exception.StudentNotFoundException;
import studentapi.model.Student;
import studentapi.model.dto.StudentRequestDTO;
import studentapi.model.dto.StudentResponseDTO;
import studentapi.repository.StudentRepository;
import studentapi.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import studentapi.model.dto.CourseResponseDTO;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentResponseDTO toResponseDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setRollNumber(student.getRollNumber());
        dto.setMarks(student.getMarks());

        if (student.getCourses() != null) {
            List<CourseResponseDTO> courseDTOs = student.getCourses()
                    .stream()
                    .map(course -> {
                        CourseResponseDTO c = new CourseResponseDTO();
                        c.setId(course.getId());
                        c.setCourseName(course.getCourseName());
                        return c;
                    })
                    .collect(Collectors.toList());
            dto.setCourses(courseDTOs);
        }

        return dto;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDTO getStudentById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return toResponseDTO(student);
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setRollNumber(dto.getRollNumber());
        student.setMarks(dto.getMarks());
        return toResponseDTO(studentRepository.save(student));
    }

    @Override
    public StudentResponseDTO updateStudent(int id, StudentRequestDTO dto) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        existing.setName(dto.getName());
        existing.setRollNumber(dto.getRollNumber());
        existing.setMarks(dto.getMarks());
        return toResponseDTO(studentRepository.save(existing));
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentResponseDTO> getStudentsWithMarksGreaterThan(int marks) {
        return studentRepository.findStudentsWithMarksGreaterThan(marks)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDTO> searchStudentsByName(String name) {
        return studentRepository.findByNameContaining(name)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDTO> getStudentsInMarksRange(int min, int max) {
        return studentRepository.findStudentsInMarksRange(min, max)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}