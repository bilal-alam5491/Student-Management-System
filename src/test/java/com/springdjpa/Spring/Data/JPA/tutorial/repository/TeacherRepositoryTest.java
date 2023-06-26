package com.springdjpa.Spring.Data.JPA.tutorial.repository;

import com.springdjpa.Spring.Data.JPA.tutorial.entity.Course;
import com.springdjpa.Spring.Data.JPA.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher() {

        Course courselist = Course.builder()
                .credit(66)
                .title("MATH")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Teacher1")
                .lastName("l1").build();
               // .courseList(List.of(courselist)).build();



        repository.save(teacher);
    }



}