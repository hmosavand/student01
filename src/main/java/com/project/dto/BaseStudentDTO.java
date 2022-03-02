package com.project.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.relational.core.mapping.Embedded;

import javax.validation.constraints.NotEmpty;

@Data
public class BaseStudentDTO {
    @NotEmpty

    private String name;
    private String family;

}
