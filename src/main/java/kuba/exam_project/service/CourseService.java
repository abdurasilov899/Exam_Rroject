package kuba.exam_project.service;

import kuba.exam_project.dto.request.CourseRequest;
import kuba.exam_project.dto.response.CourseResponse;
import kuba.exam_project.entity.Course;
import kuba.exam_project.mapper.editMapper.CourseEditMapper;
import kuba.exam_project.mapper.viewMapper.CourseViewMapper;
import kuba.exam_project.repository.CompanyRepository;
import kuba.exam_project.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {


    private final CourseRepository repository;
    private final CourseEditMapper editMapper;
    private final CourseViewMapper viewMapper;
    private final CompanyRepository companyRepository;

//    public CourseService(CourseRepository repository, CourseEditMapper editMapper, CourseViewMapper viewMapper,CompanyRepository companyRepository) {
//        this.repository = repository;
//        this.editMapper = editMapper;
//        this.viewMapper = viewMapper;
//        this.companyRepository= companyRepository;
//    }

    public CourseResponse creat(CourseRequest request,Long companyId) {
        Course course = editMapper.creat(request);
        course.setCompany(companyRepository.getById(companyId));
        try{
            repository.save(course);
        }
        catch (Exception e){
            throw new NotFoundException(String.format("There is no company with id: %s", companyId));
        }
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
