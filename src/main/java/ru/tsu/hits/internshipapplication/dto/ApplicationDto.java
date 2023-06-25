package ru.tsu.hits.internshipapplication.dto;

import ru.tsu.hits.userservice.dto.UserDto;

import java.util.List;

public class ApplicationDto {

    private String id;

    private String position_id;

    private List<UserDto> interviewers;

    private List<String> status;

    private InterviewDto interview;
}
