package kuba.exam_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "group_name")
    @NotEmpty
    private String groupName;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotEmpty
    private LocalDate start;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotEmpty
    private LocalDate finish;

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
     @JsonIgnore
    private List<Course> courses;

    @OneToMany(mappedBy="group", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Student> students;

    @ManyToOne
    @JsonIgnore
    private Company company;
}
