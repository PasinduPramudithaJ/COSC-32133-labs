package com.example.lab2.Controller;
import com.example.lab2.Model.Student;
import com.example.lab2.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

@Autowired
private StudentService studentService;
@PostMapping
public ResponseEntity<Student> saveEmployee(@RequestBody Student student){
    return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
    }
     //GetAll Rest Api
    @GetMapping
    public List<Student> getAllStudents(){
    return studentService.getAllStudents();
    }
     //Get by Id Rest Api
    @GetMapping("{id}")
     // localhost:8080/api/employees/1
    public ResponseEntity<Student> getEmployeeById(@PathVariable("id") long
    employeeID){
    return new ResponseEntity<Student>(studentService.getStudentById(employeeID),HttpStatus.OK);
    }
     //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Student> updateEmployee(@PathVariable("id") long
    id,
    @RequestBody Student employee){
    return new ResponseEntity<Student>(studentService.updateStudent(employee,id),HttpStatus.OK);
    }
     //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long
    id){
     //delete employee from db
    studentService.deleteStudent(id);
    return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
    }
    
    @GetMapping("/year/{yearOfEnrollment}")
    public List<Student> getStudentsByYearOfEnrollment(@PathVariable("yearOfEnrollment") String yearOfEnrollment) {
        return studentService.getStudentsByYearOfEnrollment(yearOfEnrollment);
    }


    @GetMapping("/department/{id}")
    public ResponseEntity<String> getDepartmentById(@PathVariable("id") long id) {
        Optional<String> department = studentService.getDepartmentById(id);
        if (department.isPresent()) {
            return new ResponseEntity<>(department.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByYear/{year}")
    public ResponseEntity<String> deleteStudentsByYearOfEnrollment(@PathVariable("year") String year) {
        studentService.deleteStudentsByYearOfEnrollment(year);
        return ResponseEntity.ok("Students enrolled in " + year + " have been deleted.");
    }

    
}
