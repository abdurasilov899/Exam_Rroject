package kuba.exam_project.controller;

import io.swagger.v3.oas.annotations.Operation;
import kuba.exam_project.dto.request.CourseRequest;
import kuba.exam_project.dto.response.CourseResponse;
import kuba.exam_project.entity.Course;
import kuba.exam_project.service.CourseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/course")
@PreAuthorize("hasAuthority('admin')")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create/{companyId}")
    @Operation(summary = "creat course",description = "we can create course")
    public CourseResponse creat(@RequestBody CourseRequest request,@PathVariable Long companyId) {
        return courseService.creat(request,companyId);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update course",description = "we can update course")
    public CourseResponse update(@PathVariable long id, @RequestBody CourseRequest request) {
        return courseService.update(id, request);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "find by id course",description = "we can find course")
    public CourseResponse findById(@PathVariable long id) {
        return courseService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete by id course",description = "we can delete course")
    public CourseResponse delete(@PathVariable long id) {
        return courseService.delete(id);
    }

    @GetMapping("/all")
    @Operation(summary = "all course",description = "we can all course")
    public List<CourseResponse> all() {
        return courseService.all();
    }
}
