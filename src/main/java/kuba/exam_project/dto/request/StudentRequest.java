package kuba.exam_project.dto.request;

import kuba.exam_project.entity.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private String name;
    private String surname;
    private String email;
    private StudyFormat studyFormat;

}
