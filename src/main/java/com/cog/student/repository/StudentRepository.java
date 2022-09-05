package com.cog.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cog.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
