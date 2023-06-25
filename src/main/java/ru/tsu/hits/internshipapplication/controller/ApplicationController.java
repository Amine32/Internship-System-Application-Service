package ru.tsu.hits.internshipapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tsu.hits.internshipapplication.dto.ApplicationDto;
import ru.tsu.hits.internshipapplication.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/{internship_id}")
    public ApplicationDto createApplication(@PathVariable String internship_id) {
        return applicationService.createApplication(internship_id);
    }

    @GetMapping()
    public List<ApplicationDto> getApplicationsByStudent(){
        return applicationService.getApplicationsByStudent();
    }

    @GetMapping("/{application_id}")
    public ApplicationDto getApplicationById(@PathVariable String application_id) {
        return applicationService.getApplicationById(application_id);
    }
}
