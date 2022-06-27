package kuba.exam_project.service;

import kuba.exam_project.dto.request.GroupRequest;
import kuba.exam_project.dto.response.GroupResponse;
import kuba.exam_project.entity.Course;
import kuba.exam_project.entity.Group;
import kuba.exam_project.exception.ThisNotFoundException;
import kuba.exam_project.mapper.editMapper.GroupEditMapper;
import kuba.exam_project.mapper.viewMapper.GroupViewMapper;
import kuba.exam_project.repository.CompanyRepository;
import kuba.exam_project.repository.CourseRepository;
import kuba.exam_project.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;
    private final GroupEditMapper editMapper;
    private final GroupViewMapper viewMapper;
    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;


    public GroupResponse creat(GroupRequest request) {
        Group group = editMapper.creat(request);
        group.setCourses(getCoursesToGroup(request.getCourse()));
        repository.save(group);
        return viewMapper.viewGroup(group);
    }

    private List<Course> getCoursesToGroup(List<Long> courseId) {
        List<Course> courses = new ArrayList<>();
        for (Long course : courseId) {
            courses.add(courseRepository.findById(course)
                    .orElseThrow(() -> new ThisNotFoundException(
                            "Course whit id = " + courseId + " not found!"
                    ))
            );
        }
        return courses;
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
