package com.avgcodes.repository;

import com.avgcodes.entity.Guardian;
import com.avgcodes.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public  void saveStudent() {
        Student student = Student.builder()
                .emaiId("avgcodes7@gmail.com")
                .firstName("avgcodes")
                .lastName("OO7")
//                .guardianName("aditya")
//                .guardianEmail("aditya@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("aditya@gmail.com")
                .name("aditya")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("atharva")
                .emaiId("atharva@gmail.com")
                .lastName("vg")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

}