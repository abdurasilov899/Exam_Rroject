package kuba.exam_project.controller;

import kuba.exam_project.dto.request.TeacherRequest;
import kuba.exam_project.dto.response.TeacherResponse;
import kuba.exam_project.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @PostMapping("/creat")
    public TeacherResponse creat(@RequestBody TeacherRequest request) {
        return service.creat(request);
    }

    @PutMapping("/update/{id}")
    public TeacherResponse update(@PathVariable long id, @RequestBody TeacherRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    public TeacherResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public TeacherResponse delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/all")
    public List<TeacherResponse> all() {
        return service.all();
    }
}
