package com.example.controller;


import com.example.dto.student.CreateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.dto.student.UpdateStudentDto;
import com.example.service.StudentService;
 import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentDto studentDto) {
        log.info("Creating student with data: {}", studentDto);
        StudentDto createdStudent = studentService.createStudent(studentDto);
        return ResponseEntity.ok(studentService.createStudent(studentDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable  Long id){
        log.info("Fetching student with id: {}", id);
        StudentDto student = studentService.getById(id);
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        log.info("Fetching all students");
        List<StudentDto> students = studentService.getAll();
        return ResponseEntity.ok(studentService.getAll());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable("id") Long id, @RequestBody UpdateStudentDto studentDto){
        log.info("Updating student with id: {} and data: {}", id, studentDto);
        StudentDto updatedStudent = studentService.update(id, studentDto);
        return ResponseEntity.ok(studentService.update(id, studentDto));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDto> delete(@PathVariable("id") Long id){
        log.info("Deleting student with id: {}", id);
        StudentDto deletedStudent = studentService.delete(id);
        return ResponseEntity.ok(studentService.delete(id));

    }



}
