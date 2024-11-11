package com.example.lab2.Service;
import java.util.List;
import java.util.Optional;

import com.example.lab2.Model.Student;

public interface StudentService {
Student saveStudent(Student student);
List<Student> getAllStudents();
Student getStudentById(long id);
Student updateStudent(Student student,long id);
void deleteStudent(long id);
List<Student> getStudentsByYearOfEnrollment(String yearOfEnrollment);
Optional<String> getDepartmentById(Long id);
void deleteStudentsByYearOfEnrollment(String year);
}