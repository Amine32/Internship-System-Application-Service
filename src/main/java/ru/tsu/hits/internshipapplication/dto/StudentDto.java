package ru.tsu.hits.internshipapplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private String id;

    private String resume;

    private List<ApplicationDto> applications;
}
