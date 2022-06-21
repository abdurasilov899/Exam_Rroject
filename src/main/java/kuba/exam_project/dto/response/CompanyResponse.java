package kuba.exam_project.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompanyResponse {
    private String name;
    private String localCountry;
    private LocalDate wasCreated;
}
