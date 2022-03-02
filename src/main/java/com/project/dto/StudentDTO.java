package com.project.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentDTO extends BaseStudentDTO  {
    private  long id;
    private  String email;
    private String address;

}
