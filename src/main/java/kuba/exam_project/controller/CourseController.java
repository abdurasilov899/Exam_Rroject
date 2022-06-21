package kuba.exam_project.controller;

import kuba.exam_project.dto.request.CourseRequest;
import kuba.exam_project.dto.response.CourseResponse;
import kuba.exam_project.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/creat/{companyId}")
    public CourseResponse creat(@RequestBody CourseRequest request,@PathVariable Long companyId) {
        return courseService.creat(request,companyId);
    }

    @PutMapping("/update/{id}")
    public CourseResponse update(@PathVariable long id, @RequestBody CourseRequest request) {
        return courseService.update(id, request);
    }

    @GetMapping("/find/{id}")
    public CourseResponse findById(@PathVariable long id) {
        return courseService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public CourseResponse delete(@PathVariable long id) {
        return courseService.delete(id);
    }

    @GetMapping("/all")
    public List<CourseResponse> all() {
        return courseService.all();
    }
}
