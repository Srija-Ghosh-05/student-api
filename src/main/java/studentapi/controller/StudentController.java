package studentapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentapi.model.dto.StudentRequestDTO;
import studentapi.model.dto.StudentResponseDTO;
import studentapi.service.StudentService;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody StudentRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(dto));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable int id,
            @Valid @RequestBody StudentRequestDTO dto) {
        return ResponseEntity.ok(studentService.updateStudent(id, dto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/search/marks")
    public ResponseEntity<List<StudentResponseDTO>> getStudentsWithMarksGreaterThan(
            @RequestParam int value) {
        return ResponseEntity.ok(studentService.getStudentsWithMarksGreaterThan(value));
    }

    @GetMapping("/students/search/name")
    public ResponseEntity<List<StudentResponseDTO>> searchStudentsByName(
            @RequestParam String name) {
        return ResponseEntity.ok(studentService.searchStudentsByName(name));
    }

    @GetMapping("/students/search/range")
    public ResponseEntity<List<StudentResponseDTO>> getStudentsInMarksRange(
            @RequestParam int min,
            @RequestParam int max) {
        return ResponseEntity.ok(studentService.getStudentsInMarksRange(min, max));
    }
}