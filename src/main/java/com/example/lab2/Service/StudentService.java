package com.example.lab2.Service;
import java.util.List;

import com.example.lab2.Model.Student;

public interface StudentService {
Student saveStudent(Student student);
List<Student> getAllStudents();
Student getStudentById(long id);
Student updateStudent(Student student,long id);
void deleteStudent(long id);
}
