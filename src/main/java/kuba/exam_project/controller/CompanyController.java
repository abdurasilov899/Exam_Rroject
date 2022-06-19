package kuba.exam_project.controller;

import kuba.exam_project.dto.request.CompanyRequest;
import kuba.exam_project.dto.response.CompanyResponse;
import kuba.exam_project.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public CompanyResponse creat(@RequestBody CompanyRequest request) {
        return service.creat(request);
    }

    @PutMapping("/update/{id}")
    public CompanyResponse update(@PathVariable long id, @RequestBody CompanyRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    public CompanyResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public CompanyResponse deleteById(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping("/all")
    public List<CompanyResponse> getAll() {
        return service.allCompany();
    }
}
