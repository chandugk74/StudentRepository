package com.chandru.studentservice.service;

import com.chandru.studentservice.dto.StudentDto;
import com.chandru.studentservice.entity.StudentEntity;
import com.chandru.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public StudentDto create(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAge(studentDto.getAge());
        studentEntity.setName(studentDto.getName());
        studentRepository.save(studentEntity);
        studentDto.setId(studentEntity.getId());
        return studentDto;
    }
    public StudentDto read(long id){
        Optional<StudentEntity> byId = studentRepository.findById(id);
        if(byId.isPresent()){
            StudentEntity row = byId.get();
            StudentDto studentDto = new StudentDto();
            studentDto.setId(row.getId());
            studentDto.setAge(row.getAge());
            studentDto.setName(row.getName());
            return studentDto;
        }
        return null;
    }

  }
