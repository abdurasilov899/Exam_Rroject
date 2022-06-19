package kuba.exam_project.mapper.viewMapper;

import kuba.exam_project.dto.response.CompanyResponse;
import kuba.exam_project.entity.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {
    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }
        CompanyResponse response = new CompanyResponse();
        response.setName(company.getName());
        response.setLocalDate(company.getLocalCountry());
        response.setLocalD(company.getLocalDate());
        return response;
    }

    public List<CompanyResponse> view(List<Company> companies) {
        List<CompanyResponse> responses = new ArrayList<>();
        for (Company response : companies) {
            responses.add(viewCompany(response));
        }
        return responses;
    }
}
