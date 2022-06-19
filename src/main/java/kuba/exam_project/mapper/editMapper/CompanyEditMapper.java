package kuba.exam_project.mapper.editMapper;

import kuba.exam_project.dto.request.CompanyRequest;
import kuba.exam_project.entity.Company;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CompanyEditMapper {

    public Company creatCompany(CompanyRequest request){
        if (request==null){
            return  null;
        }
        Company company = new Company();
        company.setName(request.getName());
        company.setLocalCountry(request.getLocalCountry());
        company.setLocalDate(LocalDate.now());
        return company;
    }
    public void updateCompany(Company company,CompanyRequest request){
        company.setName(request.getName());
        company.setLocalCountry(request.getLocalCountry());
        company.setLocalDate(LocalDate.now());
    }
}
