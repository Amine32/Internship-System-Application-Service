package ru.tsu.hits.internshipapplication.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InterviewDto {

    private String id;

    private LocalDateTime date;

    private String location;
}
