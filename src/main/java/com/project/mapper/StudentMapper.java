package com.project.mapper;

import com.project.dto.CreateStudentDTO;
import com.project.dto.StudentDTO;
import com.project.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    /*
    this method change entity to DTO
    and change DTO to entity
     */
    public Student toEntity(CreateStudentDTO createStudentDTO) {
        Student entity = new Student();
        entity.setName(createStudentDTO.getName());
        entity.setFamily(createStudentDTO.getFamily() == null ? null : createStudentDTO.getFamily());
        entity.setEmail(createStudentDTO.getEmail());
        return entity;
    }

    public StudentDTO  toDTO(Student entity){
        StudentDTO dto=new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setFamily(entity.getFamily());
        dto.setEmail(entity.getEmail());
        return dto;



    }


}
