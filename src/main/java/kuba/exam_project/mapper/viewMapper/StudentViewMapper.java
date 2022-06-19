package kuba.exam_project.mapper.viewMapper;

import kuba.exam_project.dto.response.StudentResponse;
import kuba.exam_project.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }
        StudentResponse response = new StudentResponse();
        response.setName(student.getName());
        response.setSurname(student.getSurname());
        response.setEmail(student.getEmail());
        response.setStudyFormat(student.getStudyFormat());
        response.setLocalDate(student.getLocalDate());
        response.setEnable(student.isEnable());

        return response;
    }

    public List<StudentResponse> view(List<Student> students) {
        List<StudentResponse> responses = new ArrayList<>();
        for (Student student : students) {
            responses.add(viewStudent(student));
        }
        return responses;
    }
}
