package com.herman87.demogenerateqrcode.controller;

import com.google.zxing.WriterException;
import com.herman87.demogenerateqrcode.domain.Student;
import com.herman87.demogenerateqrcode.service.StudentService;
import com.herman87.demogenerateqrcode.utils.QrCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() throws IOException, WriterException {

        List<Student> allStudents = studentService.getAllStudents();
        for (Student student : allStudents) {
            QrCodeGenerator.generateQrCode(student);
        }

        return ResponseEntity.status(HttpStatus.OK).body(allStudents);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(studentId));
    }

    @PostMapping
    public ResponseEntity<Long> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent(student));
    }
}
