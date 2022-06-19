package kuba.exam_project.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class TeacherResponse {

    private String name;
    private String surname;
}
