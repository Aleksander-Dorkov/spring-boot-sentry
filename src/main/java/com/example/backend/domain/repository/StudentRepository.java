package com.example.backend.domain.repository;

import com.example.backend.domain.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("""
             select s from Student s
             left join fetch s.courses
             where s.id=:studentId
            """)
    Student findOneWithCourses(@Param("studentId") Long studentId);
}
