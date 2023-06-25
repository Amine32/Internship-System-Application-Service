package ru.tsu.hits.internshipapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "students")
public class StudentProfile {

    //student id and user id will be the same
    @Id
    private String id;

    private String resume;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ApplicationEntity> interviews;

}
