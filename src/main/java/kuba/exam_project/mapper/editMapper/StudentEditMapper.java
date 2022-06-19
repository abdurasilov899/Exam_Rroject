package kuba.exam_project.mapper.editMapper;

import kuba.exam_project.dto.request.StudentRequest;
import kuba.exam_project.entity.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentEditMapper {
    public Student create(StudentRequest request){
        if (request ==null){
            return  null;
        }
        Student student = new Student();
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setEmail(request.getEmail());
        student.setStudyFormat(request.getStudyFormat());
        student.setLocalDate(LocalDate.now());
        student.setEnable(true);
        return student;
    }
    public  void update(Student student, StudentRequest request){
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setEmail(request.getEmail());
    }
}
