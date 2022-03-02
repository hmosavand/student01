package com.project.service;

import com.project.dto.CreateStudentDTO;
import com.project.dto.StudentDTO;
import com.project.entity.Student;
import com.project.mapper.StudentMapper;
import com.project.repo.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class StudentService {

    /// autowired
    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentDTO create(CreateStudentDTO createDTO) {
        log.debug("save DTO be started  studentDTO {}:", createDTO);

        ////////////////
        Student student = mapper.toEntity(createDTO);
        repository.save(student);

        ////////////////////
        StudentDTO dto = mapper.toDTO(student);

        log.debug("save finished , studentDTO: {}", dto);
        return dto;

    }
///// delete
    public void delete(long id) {
        repository.deleteById(id);
    }

//////by id
    public StudentDTO getStudentById(long id) {
        Optional<Student> optionalStudent = repository.findById(id);
        Student student=optionalStudent.orElseThrow(() ->
                new StudentNotFoundException("Couldn't find a Dog with id: " + id));
        return mapper.toDTO(student);
    }


    // get all
    public List<StudentDTO> getStudents() {
        return ((List<Student>) repository.findAll()).stream().filter(Objects::nonNull).
                map(mapper::toDTO).collect(Collectors.toList());
    }


}
