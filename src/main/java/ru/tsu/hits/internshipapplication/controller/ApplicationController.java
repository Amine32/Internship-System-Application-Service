package ru.tsu.hits.internshipapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tsu.hits.internshipapplication.dto.ApplicationDto;
import ru.tsu.hits.internshipapplication.service.ApplicationService;

@RestController
@RequestMapping("/api/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/{internship_id}")
    public ApplicationDto createApplication(@PathVariable String internship_id) {
        return applicationService.createApplication(internship_id);
    }

    @GetMapping("/{application_id}")
    public ApplicationDto getApplicationById(@PathVariable String application_id) {
        return applicationService.getApplicationDtoById(application_id);
    }

    @PostMapping("/{application_id}/status/{status}")
    public ApplicationDto addStatus(@PathVariable String application_id, @PathVariable String status) {
        return applicationService.addStatus(application_id, status);
    }
}
