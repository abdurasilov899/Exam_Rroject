package kuba.exam_project.service;

import kuba.exam_project.dto.request.CompanyRequest;
import kuba.exam_project.dto.response.CompanyResponse;
import kuba.exam_project.entity.Company;
import kuba.exam_project.mapper.editMapper.CompanyEditMapper;
import kuba.exam_project.mapper.viewMapper.CompanyViewMapper;
import kuba.exam_project.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyEditMapper editMapper;
    private final CompanyViewMapper viewMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyEditMapper editMapper, CompanyViewMapper viewMapper) {
        this.companyRepository = companyRepository;
        this.editMapper = editMapper;
        this.viewMapper = viewMapper;
    }

    public CompanyResponse creat(CompanyRequest request) {
        Company company = editMapper.creatCompany(request);
        companyRepository.save(company);
        return viewMapper.viewCompany(company);
    }

    public CompanyResponse update(long id, CompanyRequest request) {
        Company company = companyRepository.findById(id).get();
        editMapper.updateCompany(company, request);
        return viewMapper.viewCompany(companyRepository.save(company));
    }

    public CompanyResponse findById(long id) {
        Company company = companyRepository.findById(id).get();
        return viewMapper.viewCompany(company);
    }

    public CompanyResponse deleteById(long id) {
        Company company = companyRepository.getById(id);
        companyRepository.delete(company);
        return viewMapper.viewCompany(company);
    }

    public List<CompanyResponse> allCompany() {
        return viewMapper.view(companyRepository.findAll());
    }

}
