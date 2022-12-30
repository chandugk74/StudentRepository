package com.chandru.studentservice.service;

import com.chandru.studentservice.dto.StudentDto;

public interface StudentService {
    StudentDto create(StudentDto studentDto);
    StudentDto read(long id);
}
