# Student API

A RESTful API built with **Java Spring Boot** and **MySQL** for managing student records.

## Tech Stack
- Java 24
- Spring Boot 3.5.14
- Spring Data JPA & Hibernate
- MySQL 8.0
- Maven

## Features
- Full CRUD operations for student records
- Three-layer architecture (Controller → Service → Repository)
- Global exception handling with proper HTTP status codes
- RESTful API design

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| POST | /students | Create a new student |
| PUT | /students/{id} | Update a student |
| DELETE | /students/{id} | Delete a student |

## How to Run

### Prerequisites
- Java 17 or above
- MySQL 8.0
- Maven

### Setup
1. Clone the repository  
```bash
git clone https://github.com/Srija-Ghosh-05/student-api.git
````
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
- `404 Not Found` — student not found
- `500 Internal Server Error` — unexpected server error