package kuba.exam_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kuba.exam_project.entity.enums.StudyFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_student")
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2,max = 15)
    private String name;
    @Column(name = "surname_student")
    @NotEmpty(message = "Surname shouldn't be empty")
    @Size(min = 2 ,max = 15)
    private String surname;
    @Column(name = "email_student")
    @NotEmpty(message = "email shouldn't be empty")
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "studyFormat_student")
    @NotEmpty(message = "choose must...!!!")
    private StudyFormat studyFormat;
    @CreatedDate
    private LocalDate localDate;
    private boolean enable;

    @ManyToOne()
    @JsonIgnore
    private Group group;
}
