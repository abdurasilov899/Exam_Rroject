package kuba.exam_project.service;

import kuba.exam_project.dto.request.StudentRequest;
import kuba.exam_project.dto.response.StudentResponse;
import kuba.exam_project.entity.Student;
import kuba.exam_project.mapper.editMapper.StudentEditMapper;
import kuba.exam_project.mapper.viewMapper.StudentViewMapper;
import kuba.exam_project.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentEditMapper editMapper;
    private final StudentViewMapper viewMapper;

    public StudentService(StudentRepository repository, StudentEditMapper editMapper, StudentViewMapper viewMapper) {
        this.repository = repository;
        this.editMapper = editMapper;
        this.viewMapper = viewMapper;
    }

    public StudentResponse creat(StudentRequest request) {
        Student student = editMapper.create(request);
        repository.save(student);
        return viewMapper.viewStudent(student);
    }

    public StudentResponse update(Long id, StudentRequest request) {
        Student student = repository.findById(id).get();
        editMapper.update(student, request);
        return viewMapper.viewStudent(repository.save(student));
    }

    public StudentResponse findById(Long id) {
        Student student = repository.findById(id).get();
        return viewMapper.viewStudent(student);
    }

    public StudentResponse deleteById(Long id) {
        Student student = repository.getById(id);
        repository.delete(student);
        return viewMapper.viewStudent(student);
    }
    public List<StudentResponse> getAll(){
        return viewMapper.view(repository.findAll());
    }
}
