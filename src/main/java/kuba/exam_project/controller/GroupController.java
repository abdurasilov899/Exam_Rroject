package kuba.exam_project.controller;

import io.swagger.v3.oas.annotations.Operation;
import kuba.exam_project.dto.request.GroupRequest;
import kuba.exam_project.dto.response.GroupResponse;
import kuba.exam_project.service.GroupService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
@PreAuthorize("hasAuthority('admin')")
public class GroupController {

    public final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @Operation(summary = "creat group",description = "we can create group")
    public GroupResponse creat(@RequestBody GroupRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update Group",description = "we can update group")
    public GroupResponse update(@PathVariable long id, @RequestBody GroupRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "find by id Group",description = "we can find group")
    public GroupResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete Group",description = "we can delete group")
    public GroupResponse delete(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "all Group",description = "we can all group")
    public List<GroupResponse> all() {
        return service.all();
    }
}

