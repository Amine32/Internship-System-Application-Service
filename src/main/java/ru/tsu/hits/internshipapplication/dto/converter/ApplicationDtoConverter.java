package ru.tsu.hits.internshipapplication.dto.converter;

import org.modelmapper.ModelMapper;
import ru.tsu.hits.internshipapplication.dto.ApplicationDto;
import ru.tsu.hits.internshipapplication.dto.InterviewDto;
import ru.tsu.hits.internshipapplication.model.ApplicationEntity;
import ru.tsu.hits.internshipapplication.model.InterviewEntity;
import ru.tsu.hits.internshipapplication.model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationDtoConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ApplicationDto convertEntityToDto(ApplicationEntity application) {
        ApplicationDto dto = modelMapper.map(application, ApplicationDto.class);

        List<Status> statusList = application.getStatus();
        List<String> russianStatusList = statusList.stream()
                .map(Status::getRussian)
                .collect(Collectors.toList());
        dto.setStatus(russianStatusList);

        List<InterviewEntity> interviews = application.getInterviews();
        List<InterviewDto> interviewDtos;

        if (interviews != null) {
            interviewDtos = interviews.stream()
                    .map(InterviewDtoConverter::convertEntityToDto)
                    .collect(Collectors.toList());
        } else {
            interviewDtos = new ArrayList<>();
        }

        dto.setInterviews(interviewDtos);

        return dto;
    }
}
