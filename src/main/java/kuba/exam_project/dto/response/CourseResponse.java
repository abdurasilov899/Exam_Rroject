package kuba.exam_project.dto.response;

import kuba.exam_project.entity.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponse {

    private String courseName;
    private String duration;
    private String companyName;

}
