package kuba.exam_project.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class TeacherRequest {

    private String name;
    private String surname;
    private Long courseId;

}
