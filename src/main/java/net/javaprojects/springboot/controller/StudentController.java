package net.javaprojects.springboot.controller;

import net.javaprojects.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student

    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
            1,
            "David",
            "Todd"
        );
        return student;
    }

    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "David", "Todd"));
        students.add(new Student(2, "Viola", "Davis"));
        students.add(new Student(3, "Jamie Lee", "Curtis"));
        students.add(new Student(4, "Ariana", "DeBose"));
        return students;
    }
}
