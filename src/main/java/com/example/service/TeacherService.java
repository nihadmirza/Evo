package com.example.service;

import com.example.dto.teacher.CreateTeacherDto;
import com.example.dto.teacher.TeacherDto;
import com.example.dto.teacher.UpdateTeacherDto;
import java.util.List;

public interface TeacherService {

      TeacherDto createTeacher(CreateTeacherDto teacherDto);

      TeacherDto getById(Long id);

      List<TeacherDto> getAll();

      TeacherDto update(Long id, UpdateTeacherDto teacherDto);

      TeacherDto delete(Long id);

}
