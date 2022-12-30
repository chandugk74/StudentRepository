package com.chandru.studentservice.controller;

import com.chandru.studentservice.dto.StudentDto;
import com.chandru.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto){
        StudentDto studentDto1 = studentService.create(studentDto);
        return ResponseEntity.ok(studentDto1);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> read(@PathVariable long id){
        StudentDto studentDto = studentService.read(id);
        return ResponseEntity.ok(studentDto);
    }
}
