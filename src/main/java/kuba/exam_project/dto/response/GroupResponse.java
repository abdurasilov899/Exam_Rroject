package kuba.exam_project.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GroupResponse {


    private String groupName;
    private LocalDate start;
    private LocalDate finish;

}
