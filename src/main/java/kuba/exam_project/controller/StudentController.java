package kuba.exam_project.controller;

import io.swagger.v3.oas.annotations.Operation;
import kuba.exam_project.dto.request.StudentRequest;
import kuba.exam_project.dto.response.StudentResponse;
import kuba.exam_project.service.StudentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@PreAuthorize("hasAuthority('admin')")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/createStudent")
    @Operation(summary = "creat student",description = "we can create student")
    public StudentResponse creat(@RequestBody StudentRequest request) {
        return service.creat(request);
    }

    @PutMapping("/{id}/update")
    @Operation(summary = "update student",description = "we can update student")
    public StudentResponse update(@PathVariable long id, @RequestBody StudentRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}/find")
    @Operation(summary = "find by id student",description = "we can find student")
    public StudentResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}/delete")
    @Operation(summary = "delete student",description = "we can delete student")
    public StudentResponse deleteById(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "all student",description = "we can all student")
    public List<StudentResponse> getAll() {
        return service.getAll();
    }

}
