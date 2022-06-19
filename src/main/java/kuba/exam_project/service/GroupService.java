package kuba.exam_project.service;

import kuba.exam_project.dto.request.GroupRequest;
import kuba.exam_project.dto.response.GroupResponse;
import kuba.exam_project.entity.Group;
import kuba.exam_project.mapper.editMapper.GroupEditMapper;
import kuba.exam_project.mapper.viewMapper.GroupViewMapper;
import kuba.exam_project.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository repository;
    private final GroupEditMapper editMapper;
    private final GroupViewMapper viewMapper;

    public GroupService(GroupRepository repository, GroupEditMapper editMapper, GroupViewMapper viewMapper) {
        this.repository = repository;
        this.editMapper = editMapper;
        this.viewMapper = viewMapper;
    }

    public GroupResponse creat(GroupRequest request) {
        Group group = editMapper.creat(request);
        repository.save(group);
        return viewMapper.viewGroup(group);
    }

    public GroupResponse update(long id, GroupRequest request) {
        Group group = repository.findById(id).get();
        editMapper.update(group, request);
        return viewMapper.viewGroup(group);
    }

    public GroupResponse findById(long id) {
        Group group = repository.findById(id).get();
        return viewMapper.viewGroup(group);
    }

    public GroupResponse deleteById(long id) {
        Group group = repository.getById(id);
        repository.delete(group);
        return viewMapper.viewGroup(group);
    }

    public List<GroupResponse> all() {
        return viewMapper.view(repository.findAll());
    }
}
