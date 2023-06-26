package com.springdjpa.Spring.Data.JPA.tutorial.repository;

import com.springdjpa.Spring.Data.JPA.tutorial.entity.Guardian;
import com.springdjpa.Spring.Data.JPA.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .firstName("Bilal")
                .lastName("Alam")
                .emailId("bilal@gmail.com")
//                .guardianName("ALAM")
//                .guardianEmail("ALAM@gmail.com")
//                .guardianMobile("123123123")
                .build();

        studentRepository.save(student);

    }


    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("guard")
                .mobile("123")
                .email("guard@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Bilal")
                .lastName("Alam")
                .emailId("bilal1@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }


    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }


    @Test
    public void printStudentByFirstName() {
        List<Student> studentName = studentRepository.findByFirstName("bilal");
        System.out.println("studentList = " + studentName);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentName = studentRepository.findByFirstNameContaining("bi");
        System.out.println("studentList = " + studentName);
    }

    @Test
    public void printStudentByGaurdianName() {
        List<Student> studentName = studentRepository.findByGuardianName("guard");
        System.out.println("studentList = " + studentName);
    }


    @Test
    public void printgetStudentbyEmail() {
        Student student = studentRepository.getStudentByEmailAddress("bilal@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNamebyEmail() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("bilal@gmail.com");
        System.out.println("student = " + student);
    }


    @Test
    public void printgetStudentbyEmailNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("bilal@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentbyEmailNativeParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeParam("bilal@gmail.com");
        System.out.println("student = " + student);
    }


    @Test
    public void updateStudentFirstNameByEmailTest() {

        studentRepository.updateStudentFirstNameByEmail("BILAL","bilal@gmail.com");

    }


}