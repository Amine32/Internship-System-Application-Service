package ru.tsu.hits.internshipapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tsu.hits.internshipapplication.dto.CreateUpdateInterviewDto;
import ru.tsu.hits.internshipapplication.dto.InterviewDto;
import ru.tsu.hits.internshipapplication.repository.InterviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;

    public InterviewDto createInterview(CreateUpdateInterviewDto dto, String applicationId) {

    }

    public List<InterviewDto> getInterviewsByApplicationId(String applicationId) {

    }

    public InterviewDto getInterviewById(String id) {

    }
}
