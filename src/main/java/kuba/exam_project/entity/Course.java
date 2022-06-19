package kuba.exam_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "course_Name")
    @NotEmpty
    private String courseName;
    @NotEmpty
    @Column(name = "course_duration")
    private String duration;

    @ManyToMany(mappedBy="courses", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Group> group;

    @OneToOne(mappedBy = "course", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Teacher teacher;

    @ManyToOne
    @JsonIgnore
    private Company company;
}
