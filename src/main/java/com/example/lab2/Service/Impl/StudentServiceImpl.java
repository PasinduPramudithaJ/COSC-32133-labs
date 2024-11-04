package com.example.lab2.Service.Impl;
import com.example.lab2.Model.Student;
import com.example.lab2.Repository.StudentRepository;
import com.example.lab2.Service.StudentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> employee = studentRepository.findById(id);
        if(employee.isPresent()){
        return employee.get();
        }else {
        throw new RuntimeException();
        }
    }
    

@Override
    public Student updateStudent(Student student, long id) {
    Student existingStudent =studentRepository.findById(id).orElseThrow(()-> new RuntimeException());
existingStudent.setFirstName(student.getFirstName());
existingStudent.setLastName(student.getLastName());
existingStudent.setEmail(student.getEmail());
existingStudent.setDepartment(student.getDepartment());
existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
 // save
studentRepository.save(existingStudent);
return existingStudent;

    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow(()-> new
        RuntimeException());
         //delete
        studentRepository.deleteById(id);}


    }
    

