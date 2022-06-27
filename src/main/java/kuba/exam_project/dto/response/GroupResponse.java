package kuba.exam_project.dto.response;

import kuba.exam_project.entity.Company;
import kuba.exam_project.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GroupResponse {

    private String groupName;
    private LocalDate start;
    private LocalDate finish;
    private List<String> coursesName;
}
