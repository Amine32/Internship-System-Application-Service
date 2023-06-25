package ru.tsu.hits.internshipapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tsu.hits.internshipapplication.dto.ApplicationDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    public ApplicationDto createApplication(String internshipId) {

    }

    public List<ApplicationDto> getApplicationsByStudent() {

    }

    public ApplicationDto getApplicationById(String applicationId) {

    }

    public ApplicationDto setInterviewer(String applicationId, String userId) {

    }

    public ApplicationDto addStatus(String applicationId, String status) {

    }
}
