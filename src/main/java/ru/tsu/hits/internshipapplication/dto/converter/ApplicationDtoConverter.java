package ru.tsu.hits.internshipapplication.dto.converter;

import org.modelmapper.ModelMapper;
import ru.tsu.hits.internshipapplication.dto.ApplicationDto;
import ru.tsu.hits.internshipapplication.model.ApplicationEntity;

public class ApplicationDtoConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ApplicationDto convertEntityToDto(ApplicationEntity application) {
        return modelMapper.map(application, ApplicationDto.class);
    }
}
