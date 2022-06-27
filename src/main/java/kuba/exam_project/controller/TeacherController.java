package kuba.exam_project.controller;

import io.swagger.v3.oas.annotations.Operation;
import kuba.exam_project.dto.request.TeacherRequest;
import kuba.exam_project.dto.response.TeacherResponse;
import kuba.exam_project.service.TeacherService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@PreAuthorize("hasAuthority('admin')")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @Operation(summary = "creat teacher",description = "we can create teacher")
    public TeacherResponse creat(@RequestBody TeacherRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update Teacher",description = "we can update teacher")
    public TeacherResponse update(@PathVariable long id, @RequestBody TeacherRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "find by id Teacher",description = "we can find teacher")
    public TeacherResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete Teacher",description = "we can delete teacher")
    public TeacherResponse delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/all")
    @Operation(summary = "all Teacher",description = "we can all teacher")
    public List<TeacherResponse> all() {
        return service.all();
    }
}
