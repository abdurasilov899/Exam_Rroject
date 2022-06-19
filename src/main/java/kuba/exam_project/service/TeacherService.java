package kuba.exam_project.service;

import kuba.exam_project.dto.request.TeacherRequest;
import kuba.exam_project.dto.response.TeacherResponse;
import kuba.exam_project.entity.Teacher;
import kuba.exam_project.mapper.editMapper.TeacherEditMapper;
import kuba.exam_project.mapper.viewMapper.TeacherViewMapper;
import kuba.exam_project.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TeacherService {

    private final TeacherRepository repository;
    private final TeacherEditMapper editMapper;
    private final TeacherViewMapper viewMapper;

    public TeacherService(TeacherRepository repository, TeacherEditMapper editMapper, TeacherViewMapper viewMapper) {
        this.repository = repository;
        this.editMapper = editMapper;
        this.viewMapper = viewMapper;
    }

    public TeacherResponse creat(TeacherRequest request) {
        Teacher teacher = editMapper.creat(request);
        repository.save(teacher);
        return viewMapper.viewTeacher(teacher);
    }

    public TeacherResponse update(long id, TeacherRequest request) {
        Teacher teacher = repository.findById(id).get();
        repository.save(teacher);
        return viewMapper.viewTeacher(teacher);
    }

    public TeacherResponse findById(long id) {
        Teacher teacher = repository.findById(id).get();
        return viewMapper.viewTeacher(teacher);
    }

    public TeacherResponse delete(long id) {
        Teacher teacher = repository.getById(id);
        repository.delete(teacher);
        return viewMapper.viewTeacher(teacher);
    }

    public List<TeacherResponse> all() {
        return viewMapper.view(repository.findAll());
    }
}
