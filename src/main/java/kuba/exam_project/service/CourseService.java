package kuba.exam_project.service;

import kuba.exam_project.dto.request.CourseRequest;
import kuba.exam_project.dto.response.CourseResponse;
import kuba.exam_project.entity.Course;
import kuba.exam_project.mapper.editMapper.CourseEditMapper;
import kuba.exam_project.mapper.viewMapper.CourseViewMapper;
import kuba.exam_project.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseService {


    private final CourseRepository repository;
    private final CourseEditMapper editMapper;
    private final CourseViewMapper viewMapper;

    public CourseService(CourseRepository repository, CourseEditMapper editMapper, CourseViewMapper viewMapper) {
        this.repository = repository;
        this.editMapper = editMapper;
        this.viewMapper = viewMapper;
    }

    public CourseResponse creat(CourseRequest request) {
        Course course = editMapper.creat(request);
        repository.save(course);
        return viewMapper.viewCourse(course);
    }

    public CourseResponse update(long id, CourseRequest request) {
        Course course = repository.findById(id).get();
        editMapper.update(course, request);
        return viewMapper.viewCourse(repository.save(course));
    }

    public CourseResponse findById(long id) {
        Course course = repository.findById(id).get();
        return viewMapper.viewCourse(course);
    }

    public CourseResponse delete(long id) {
        Course course = repository.getById(id);
        repository.delete(course);
        return viewMapper.viewCourse(course);
    }

    public List<CourseResponse> all() {
        return viewMapper.view(repository.findAll());
    }
}
