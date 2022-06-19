package kuba.exam_project.controller;

import kuba.exam_project.dto.request.GroupRequest;
import kuba.exam_project.dto.response.GroupResponse;
import kuba.exam_project.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    public final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @PostMapping("/creat")
    public GroupResponse creat(@RequestBody GroupRequest request) {
        return service.creat(request);
    }

    @PutMapping("/update/{id}")
    public GroupResponse update(@PathVariable long id, @RequestBody GroupRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    public GroupResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public GroupResponse delete(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping("/all")
    public List<GroupResponse> all() {
        return service.all();
    }
}

