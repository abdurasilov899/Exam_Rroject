package kuba.exam_project.dto.request;

import kuba.exam_project.entity.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {

    private String courseName;
    private String duration;
}
