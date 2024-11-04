package com.example.lab2.Controller;
import com.example.lab2.Model.Student;
import com.example.lab2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    
}
