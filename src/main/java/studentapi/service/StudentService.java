package studentapi.service;

import studentapi.model.dto.StudentRequestDTO;
import studentapi.model.dto.StudentResponseDTO;
import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO getStudentById(int id);
    StudentResponseDTO createStudent(StudentRequestDTO dto);
    StudentResponseDTO updateStudent(int id, StudentRequestDTO dto);
    void deleteStudent(int id);

    // Custom query methods
    List<StudentResponseDTO> getStudentsWithMarksGreaterThan(int marks);
    List<StudentResponseDTO> searchStudentsByName(String name);
    List<StudentResponseDTO> getStudentsInMarksRange(int min, int max);
}