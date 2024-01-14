package com.herman87.demogenerateqrcode.repository;

import com.herman87.demogenerateqrcode.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
