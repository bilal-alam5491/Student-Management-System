package com.springdjpa.Spring.Data.JPA.tutorial.repository;

import com.springdjpa.Spring.Data.JPA.tutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {


}
