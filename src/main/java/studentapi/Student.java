package studentapi;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String rollNumber;
    private int marks;

    public Student() {}

    public Student(String name, String rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public int getMarks() { return marks; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    public void setMarks(int marks) { this.marks = marks; }
}