package kuba.exam_project.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CompanyRequest {
    private String name;
    private String localCountry;
}
