package com.project.controller;

import com.project.dto.CreateStudentDTO;
import com.project.dto.StudentDTO;
import com.project.entity.Student;
import com.project.mapper.StudentMapper;
import com.project.repo.StudentRepository;
import com.project.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    //Autowired service

    private final StudentService service;
    // save
    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody CreateStudentDTO InputDTO){
        log.info("REST be started createDTO{}:",InputDTO);
        StudentDTO dto= service.create(InputDTO);
        return ResponseEntity.created(URI.create("/api/students")).body(dto);
    }

////get by id
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable(required = true) long id) {
        StudentDTO dto=service.getStudentById(id);
        return ResponseEntity.created(URI.create("/api/students")).body(dto);
    }



////// delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
///get all

    @GetMapping
    public List<StudentDTO> getStudent() {
        return service.getStudents();
    }



}
