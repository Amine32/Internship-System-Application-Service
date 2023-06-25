package ru.tsu.hits.internshipapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsu.hits.internshipapplication.model.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, String> {
}
