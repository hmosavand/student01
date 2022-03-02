package com.project.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateStudentDTO extends BaseStudentDTO{

   private String email;

}
