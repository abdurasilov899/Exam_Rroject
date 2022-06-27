package kuba.exam_project.service;

import kuba.exam_project.dto.request.TeacherRequest;
import kuba.exam_project.dto.response.TeacherResponse;
import kuba.exam_project.entity.Course;
import kuba.exam_project.entity.Teacher;
import kuba.exam_project.exception.ThisNotFoundException;
import kuba.exam_project.mapper.editMapper.TeacherEditMapper;
import kuba.exam_project.mapper.viewMapper.TeacherViewMapper;
import kuba.exam_project.repository.CourseRepository;
import kuba.exam_project.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service

public class TeacherService {

    private final TeacherRepository repository;
    private final CourseRepository courseRepository;
    private final TeacherEditMapper editMapper;
    private final TeacherViewMapper viewMapper;

    public TeacherService(TeacherRepository repository, CourseRepository courseRepository, TeacherEditMapper editMapper, TeacherViewMapper viewMapper) {
        this.repository = repository;
        this.courseRepository = courseRepository;
        this.editMapper = editMapper;
        this.viewMapper = viewMapper;
    }

//    public TeacherResponse creat(TeacherRequest request) {
//        Teacher teacher = editMapper.creat(request);
//        Course course = teacher.getCourse();
//        if (course == null){
//            repository.save(teacher);
//        }else {
//            throw new RuntimeException(
//                    "Teacher more one!"
//            );
//        }
//
//        return viewMapper.viewTeacher(teacher);
//    }
    public TeacherResponse create(TeacherRequest request) throws HttpClientErrorException.BadRequest {
        Teacher teacher = editMapper.creat(request);
        Course curse = getCourseToTeacher(request.getCourseId());
        Teacher courseTeacher = curse.getTeacher();
        if (courseTeacher == null){
            teacher.setCourse(curse);
            repository.save(teacher);
        }else {
            throw new ThisNotFoundException(
                    "This course has a teacher !" +
                    " Name teacher: "+ courseTeacher.getName()+"!");
        }

        return viewMapper.viewTeacher(teacher);
    }

    private Course getCourseToTeacher(Long id){
        return courseRepository.findById(id)
                .orElseThrow( () -> new ThisNotFoundException(
                        "Course whit id = " +id +" not found!"
                ));
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
