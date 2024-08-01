package com.example.controller;

import com.example.dto.teacher.CreateTeacherDto;
import com.example.dto.teacher.TeacherDto;
import com.example.dto.teacher.UpdateTeacherDto;
import com.example.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
@Slf4j
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody CreateTeacherDto teacherDto) {
        log.info("Creating teacher with data: {}", teacherDto);
        return ResponseEntity.ok(teacherService.createTeacher(teacherDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getById(@PathVariable  Long id){
        log.info("Fetching teacher with id: {}", id);
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAll(){
        log.info("Fetching all teachers");
        return ResponseEntity.ok(teacherService.getAll());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<TeacherDto> update(@PathVariable("id") Long id, @RequestBody UpdateTeacherDto teacherDto){
        log.info("Updating teacher with id: {} and data: {}", id, teacherDto);
        return ResponseEntity.ok(teacherService.update(id, teacherDto));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TeacherDto> delete(@PathVariable("id") Long id){
        log.info("Deleting teacher with id: {}", id);
        return ResponseEntity.ok(teacherService.delete(id));

    }

}
