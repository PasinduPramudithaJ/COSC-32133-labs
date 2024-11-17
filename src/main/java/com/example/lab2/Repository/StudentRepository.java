package com.example.lab2.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

import com.example.lab2.Model.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByYearOfEnrollment(String yearOfEnrollment);

    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    Optional<String> findDepartmentById(Long id);

    @Transactional
    @Query("DELETE FROM Student s WHERE s.yearOfEnrollment = :year")
    void delete(String year);

}
