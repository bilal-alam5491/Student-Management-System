package com.springdjpa.Spring.Data.JPA.tutorial.repository;

import com.springdjpa.Spring.Data.JPA.tutorial.entity.Course;
import com.springdjpa.Spring.Data.JPA.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();


        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course).
                build();


        repository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterial(){

        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);

    }

}