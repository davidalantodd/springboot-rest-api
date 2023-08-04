package net.javaprojects.springboot.controller;

import net.javaprojects.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students") //will provide base URL of "students" for all routes
public class StudentController {

    // http://localhost:8080/student

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
            1,
            "David",
            "Todd"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student); same as above^
        return ResponseEntity.ok()
                .header("custom-header", "david")
                .body(student);

    }

    // http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "David", "Todd"));
        students.add(new Student(2, "Viola", "Davis"));
        students.add(new Student(3, "Jamie Lee", "Curtis"));
        students.add(new Student(4, "Ariana", "DeBose"));
        return ResponseEntity.ok(students);
    }

    // Spring Boot REST API with Path Variable
    //{id} - URI template variable
    // http://localhost:8080/students/1/david/todd
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        //@PathVariable notation will bind argument to value of URL template variable
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API with Request Param
    // to incorporate query parameters
    // http://localhost:8080/students/query?id=1&firstName=David&lastName=Todd
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API that handles HTTP Post Request - create new resource
    // @PostMapping and @RequestBody
    @PostMapping("create") //map this to a HTTP Post request
//    @ResponseStatus(HttpStatus.CREATED) can use to send back the 201 status instead of 200
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        //@RequestBody will get the HTTP request body (JSON) and convert it to Java object
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring Boot REST API that handles HTTP PUT request - update existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring Boot REST API that handles HTTP DELETE request - delete existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

    //ResponseEntity represnts the entire response (status code, headers, body)

}
