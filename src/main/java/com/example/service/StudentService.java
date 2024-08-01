package com.example.service;

import com.example.dto.student.CreateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.dto.student.UpdateStudentDto;
import java.util.List;

public interface StudentService {

    StudentDto createStudent(CreateStudentDto studentDto);

    StudentDto getById(Long id);

    List<StudentDto> getAll();

    StudentDto update(Long id, UpdateStudentDto studentDto);

    StudentDto delete(Long id);

}
