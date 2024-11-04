package com.example.lab2.Model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Student")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String firstName;
private String lastName;
private String email;
private String department;
private String yearOfEnrollment;

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

// Getter and Setter for firstName
public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

// Getter and Setter for email
public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

// Getter and Setter for department
public String getDepartment() {
    return department;
}

public void setDepartment(String department) {
    this.department = department;
}

// Getter and Setter for yearOfEnrollment
public String getYearOfEnrollment() {
    return yearOfEnrollment;
}

public void setYearOfEnrollment(String yearOfEnrollment) {
    this.yearOfEnrollment = yearOfEnrollment;
}

}
