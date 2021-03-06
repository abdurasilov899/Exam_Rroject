package kuba.exam_project.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GroupRequest {

    private String groupName;
    private LocalDate start;
    private LocalDate finish;
    private List<Long> course;
}
