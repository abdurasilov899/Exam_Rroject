package kuba.exam_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "company_name")
    private String name;
    @Column(name = "company_country")
    private String localCountry;
    @CreatedDate
    private LocalDate localDate;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE,CascadeType.REMOVE},mappedBy = "company")
    private List<Course> courses;

    public void  setCourse(Course course){
        this.courses.add(course);
    }
}
