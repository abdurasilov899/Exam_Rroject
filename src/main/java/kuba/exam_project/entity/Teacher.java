package kuba.exam_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "teacher_name")
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2,max = 15)
    private String name;
    @Column(name = "teacher_surname")
    @NotEmpty(message = "Surname shouldn't be empty")
    @Size(min = 2,max = 15)
    private String surname;
    @OneToOne
    @JsonIgnore
    private Course course;
}
