package com.springdjpa.Spring.Data.JPA.tutorial.repository;

import com.springdjpa.Spring.Data.JPA.tutorial.entity.Course;
import com.springdjpa.Spring.Data.JPA.tutorial.entity.Student;
import com.springdjpa.Spring.Data.JPA.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void saveCourseWithTeacher() {


        Teacher teacher = Teacher.builder().firstName("T2").lastName("t2").build();
        Course course = Course.builder().title("JAVA-CORE").credit(33).teacher(teacher).build();


        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {

        PageRequest firstPageWithThreeRecords = PageRequest.of(0, 3);
        PageRequest secondPageWithTwoRecords = PageRequest.of(1, 2);


        List<Course> courseList = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println("courseList = " + courseList);


    }
@Test
    public void findAllSorting() {
        PageRequest sortByTitle = PageRequest.of(0, 3, Sort.by("title"));
        PageRequest sortByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());
        PageRequest sortByTitleAndCreditDesc = PageRequest.of(0, 3, Sort.by("title").descending().and(Sort.by("credit").descending()));

        List<Course> courseList = courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println("courseList = " + courseList);

    }


    @Test
    public void printPagebyTitleContaining(){

       PageRequest pageRequest = PageRequest.of(0,5);
       List<Course> courseList = courseRepository.findByTitleContaining("D", pageRequest).getContent();

        System.out.println("courseList = " + courseList);
    }

    @Test
    public  void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder().firstName("Alina").lastName("Alina").build();
        Student student = Student.builder().firstName("Morgan").lastName("Freeman").emailId("morgan@gmail.com").build();

        Course course = Course.builder().title("AI").credit(2).teacher(teacher).build();

        course.addStudents(student);
        courseRepository.save(course);

    }

}