package com.example.service.impl;

import com.example.exception.StudentNotFoundException;
import com.example.mapper.StudentMapper;
import com.example.dto.student.CreateStudentDto;
import com.example.dto.student.StudentDto;
import com.example.dto.student.UpdateStudentDto;
import com.example.entity.StudentEntity;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {

    private  final StudentMapper studentMapper;
    private  final StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(CreateStudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.toStudentEntity(studentDto);
        StudentEntity saveStudent = studentRepository.save(studentEntity);
        return studentMapper.toStudentDto(saveStudent);
    }

    @Override
    public StudentDto getById(Long id) {

        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student not found " + id));
        return studentMapper.toStudentDto(studentEntity);
    }

    @Override
    public List<StudentDto> getAll() {
        return   studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentDto)
                .toList();


    }

    @Override
    public StudentDto update(Long id, UpdateStudentDto updateStudentDto) {
        StudentEntity studentEntity = studentRepository.findById(id)
            .orElseThrow(()->new StudentNotFoundException("Student not found " + id));
        StudentEntity updateStudent = studentMapper.toStudentEntity(updateStudentDto, studentEntity);
        return studentMapper.toStudentDto(studentRepository.save(updateStudent));

    }

    @Override
    public StudentDto delete(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student not found " + id));
        studentRepository.delete(studentEntity);
        return studentMapper.toStudentDto(studentEntity);
    }
}
