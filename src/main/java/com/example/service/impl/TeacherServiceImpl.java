package com.example.service.impl;

import com.example.exception.TeacherNotFoundException;
import com.example.mapper.TeacherMapper;
import com.example.dto.teacher.CreateTeacherDto;
import com.example.dto.teacher.TeacherDto;
import com.example.dto.teacher.UpdateTeacherDto;
import com.example.entity.TeacherEntity;
import com.example.repository.TeacherRepository;
import com.example.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TeacherServiceImpl implements TeacherService {

    private  final TeacherMapper teacherMapper;
    private  final TeacherRepository teacherRepository;

    @Override
    public TeacherDto createTeacher(CreateTeacherDto teacherDto) {
        TeacherEntity teacherEntity = teacherMapper.toTeacherEntity(teacherDto);
        TeacherEntity saveTeacher = teacherRepository.save(teacherEntity);
        return teacherMapper.toTeacherDto(saveTeacher);
    }

    @Override
    public TeacherDto getById(Long id) {

        TeacherEntity teacherEntity = teacherRepository.findById(id)
                .orElseThrow(()->new TeacherNotFoundException("Teacher not found " + id));
        return teacherMapper.toTeacherDto(teacherEntity);
    }

    @Override
    public List<TeacherDto> getAll() {
        return   teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toTeacherDto)
                .toList();


    }

    @Override
    public TeacherDto update(Long id, UpdateTeacherDto updateTeacherDto) {
        TeacherEntity teacherEntity = teacherRepository.findById(id)
            .orElseThrow(()->new TeacherNotFoundException("Teacher not found " + id));
        TeacherEntity updateTeacher = teacherMapper.toTeacherEntity(updateTeacherDto, teacherEntity);
        return teacherMapper.toTeacherDto(teacherRepository.save(updateTeacher));

    }

    @Override
    public TeacherDto delete(Long id) {
        TeacherEntity teacherEntity = teacherRepository.findById(id)
                .orElseThrow(()->new TeacherNotFoundException("Teacher not found " + id));
        teacherRepository.delete(teacherEntity);
        return teacherMapper.toTeacherDto(teacherEntity);
    }
}
