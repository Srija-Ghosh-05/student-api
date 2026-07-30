# Student API
A RESTful API built with **Java Spring Boot** and **MySQL** for managing student records and their courses.

## Tech Stack
- Java 24
- Spring Boot 3.5.14
- Spring Data JPA & Hibernate
- MySQL 8.0
- Maven

## Features
- Full CRUD operations for student records
- Course management with OneToMany relationship (one student → many courses)
- Three-layer architecture (Controller → Service → Repository)
- DTO pattern (StudentRequestDTO, StudentResponseDTO, CourseRequestDTO, CourseResponseDTO)
- Bean Validation with meaningful error messages (@NotBlank, @Min, @Max, @NotNull)
- Custom JPA queries (search by name, filter by marks, marks range)
- Global exception handling with proper HTTP status codes
- Professional package structure (controller, service, service/impl, repository, model, model/dto, exception, config)
- RESTful API design

## Project Structure
```
src/main/java/studentapi/
├── controller/
│   ├── StudentController.java
│   └── CourseController.java
├── service/
│   ├── StudentService.java
│   ├── CourseService.java
│   └── impl/
│       ├── StudentServiceImpl.java
│       └── CourseServiceImpl.java
├── repository/
│   ├── StudentRepository.java
│   └── CourseRepository.java
├── model/
│   ├── Student.java
│   ├── Course.java
│   └── dto/
│       ├── StudentRequestDTO.java
│       ├── StudentResponseDTO.java
│       ├── CourseRequestDTO.java
│       └── CourseResponseDTO.java
├── exception/
│   ├── StudentNotFoundException.java
│   └── GlobalExceptionHandler.java
└── config/
```

## API Endpoints

### Student Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| POST | /students | Create a new student |
| PUT | /students/{id} | Update a student |
| DELETE | /students/{id} | Delete a student |

### Course Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /students/{studentId}/courses | Add a course to a student |
| GET | /students/{studentId}/courses | Get all courses of a student |
| DELETE | /courses/{courseId} | Delete a course |

### Search Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students/search/marks?value=80 | Get students with marks greater than value |
| GET | /students/search/name?name=srija | Search students by name (partial, case-insensitive) |
| GET | /students/search/range?min=60&max=90 | Get students with marks in a range |

## Request & Response Examples

### Create Student
**Request Body:**
```json
{
  "name": "Srija",
  "rollNumber": "CS2023",
  "marks": 95
}
```
**Response (201 Created):**
```json
{
  "id": 1,
  "name": "Srija",
  "rollNumber": "CS2023",
  "marks": 95,
  "courses": []
}
```

### Add Course to Student
**Request Body:**
```json
{
  "courseName": "Mathematics"
}
```
**Response (201 Created):**
```json
{
  "id": 1,
  "courseName": "Mathematics"
}
```

### Validation Error Example
**Request Body:**
```json
{
  "name": "",
  "rollNumber": "CS2023",
  "marks": 999
}
```
**Response (400 Bad Request):**
```json
{
  "name": "Name cannot be blank",
  "marks": "Marks cannot be more than 100"
}
```

## How to Run

### Prerequisites
- Java 17 or above
- MySQL 8.0
- Maven

### Setup

1. Clone the repository
```bash
git clone https://github.com/Srija-Ghosh-05/student-api.git
```

2. Create a MySQL database
```sql
CREATE DATABASE studentdb;
```

3. Copy `src/main/resources/application.properties.example`
   to `src/main/resources/application.properties`
   and fill in your MySQL credentials

4. Run the application
```bash
mvn spring-boot:run
```

The server will start at `http://localhost:8080`

## HTTP Status Codes Used
- `200 OK` — successful GET and PUT requests
- `201 Created` — successful POST request
- `204 No Content` — successful DELETE request
- `400 Bad Request` — validation failure (blank fields, invalid marks)
- `404 Not Found` — student or course not found
- `500 Internal Server Error` — unexpected server error
