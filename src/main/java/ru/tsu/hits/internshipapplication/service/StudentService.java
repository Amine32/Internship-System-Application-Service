package ru.tsu.hits.internshipapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsu.hits.internshipapplication.dto.StudentDto;
import ru.tsu.hits.internshipapplication.dto.converter.StudentDtoConverter;
import ru.tsu.hits.internshipapplication.model.ProcessedEvent;
import ru.tsu.hits.internshipapplication.model.StudentProfile;
import ru.tsu.hits.internshipapplication.repository.ProcessedEventRepository;
import ru.tsu.hits.internshipapplication.repository.StudentRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ProcessedEventRepository processedEventRepository;

    @Transactional(readOnly = true)
    public StudentDto getStudentById(String id) {
        return StudentDtoConverter.convertEntityToDto(studentRepository.getById(id));
    }

    @RabbitListener(queues = "student.user.created")
    @Transactional
    public void handleStudentUserCreatedEvent(Map<String, String> message) {
        String id = message.get("id");
        String eventType = message.get("type");

        //Check if this event has already been processed
        String eventId = eventType + "-" + id;
        if(processedEventRepository.existsById(eventId)){
            return;
        }

        StudentProfile profile = new StudentProfile();
        profile.setId(id);
        studentRepository.save(profile);

        //Store the event ID to ensure it's not processed more than once
        processedEventRepository.save(new ProcessedEvent(eventId));
    }

    @RabbitListener(queues = "user.deleted")
    @Transactional
    public void handleUserDeletedEvent(Map<String, String> message) {
        String id = message.get("id");
        String eventType = message.get("type");

        //Check if this event has already been processed
        String eventId = eventType + "-" + id;
        if(processedEventRepository.existsById(eventId)) {
            return;
        }

        //Create a new StudentProfile and save it to the database
        StudentProfile profile = new StudentProfile();
        profile.setId(id);
        studentRepository.save(profile);

        //Store the event ID to ensure it's not processed more than once
        processedEventRepository.save(new ProcessedEvent(eventId));
    }
}
