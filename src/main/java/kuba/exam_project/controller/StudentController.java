package kuba.exam_project.controller;

import kuba.exam_project.dto.request.StudentRequest;
import kuba.exam_project.dto.response.StudentResponse;
import kuba.exam_project.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/creatStudent")
    public StudentResponse creat(@RequestBody StudentRequest request) {
        return service.creat(request);
    }

    @PutMapping("/{id}/update")
    public StudentResponse update(@PathVariable long id, @RequestBody StudentRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}/find")
    public StudentResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}/delete")
    public StudentResponse deleteById(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping("/all")
    public List<StudentResponse> getAll() {
        return service.getAll();
    }

}
