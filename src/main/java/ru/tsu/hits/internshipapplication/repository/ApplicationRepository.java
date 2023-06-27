package ru.tsu.hits.internshipapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsu.hits.internshipapplication.model.ApplicationEntity;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, String> {
    public List<ApplicationEntity> findAllByPositionId(String positionId);
}
