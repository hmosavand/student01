package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "students",indexes = {@Index(name = "email_index",columnList = "email")})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  long id;


    private String name;

    private String family;
    private  String email;



}
