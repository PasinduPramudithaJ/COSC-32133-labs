package com.example.lab2.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab2.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
