package kuba.exam_project.dto.request;

import kuba.exam_project.entity.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StudentRequest {

    private String name;
    private String surname;
    private String email;
    private StudyFormat studyFormat;

}
