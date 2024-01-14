package com.herman87.demogenerateqrcode.controller;

import com.herman87.demogenerateqrcode.domain.Student;
import com.herman87.demogenerateqrcode.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(studentId));
    }

    @GetMapping
    public ResponseEntity<Long> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent(student));
    }
}
