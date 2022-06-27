package kuba.exam_project.controller;

import io.swagger.v3.oas.annotations.Operation;
import kuba.exam_project.dto.request.CompanyRequest;
import kuba.exam_project.dto.response.CompanyResponse;
import kuba.exam_project.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
@PreAuthorize("hasAuthority('admin')")
public class CompanyController {

    private final CompanyService service;

    @PostMapping("/save")
    @Operation(summary = "create Company",description = "we can create company")
    public CompanyResponse creat(@RequestBody CompanyRequest request) {
        return service.creat(request);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update Company",description = "we can update company")
    public CompanyResponse update(@PathVariable long id, @RequestBody CompanyRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "find by id Company",description = "we can find company")
    public CompanyResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete Company",description = "we can delete company")
    public CompanyResponse deleteById(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "all Company",description = "we can all company")
    public List<CompanyResponse> getAll() {
        return service.allCompany();
    }

//    @PutMapping("/{companyId}/courses/{courseId}")
//    Company setCourseToCompany(
//            @PathVariable Long companyId,
//            @PathVariable Long courseId
//    ){
//        Company company = companyRepository.findById(companyId).get();
//        Course course = courseRepository.findById(courseId).get();
//        company.setCourse(course);
//        course.setCompany(company);
//        return companyRepository.save(company);
//
//    }
}
