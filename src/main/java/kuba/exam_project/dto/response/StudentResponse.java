package kuba.exam_project.dto.response;

import kuba.exam_project.entity.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
public class StudentResponse {

    private String name;
    private String surname;
    private String email;
    private StudyFormat studyFormat;
    private LocalDate localDate;
    private boolean enable;

}
