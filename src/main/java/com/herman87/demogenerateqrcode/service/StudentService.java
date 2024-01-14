package com.herman87.demogenerateqrcode.service;

import com.herman87.demogenerateqrcode.domain.Student;
import com.herman87.demogenerateqrcode.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow();
    }

    public Long createStudent(Student student) {
        return studentRepository.save(student).getId();
    }
}
