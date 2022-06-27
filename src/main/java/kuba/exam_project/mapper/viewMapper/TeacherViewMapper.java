package kuba.exam_project.mapper.viewMapper;

import kuba.exam_project.dto.response.TeacherResponse;
import kuba.exam_project.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {

    public TeacherResponse viewTeacher(Teacher teacher) {

        if (teacher == null) {
            return null;
        }
        TeacherResponse response = new TeacherResponse();
        response.setName(teacher.getName());
        response.setSurname(teacher.getSurname());
        response.setCourseName(teacher.getCourse().getCourseName());
        return response;
    }

    public List<TeacherResponse> view(List<Teacher> teachers) {
        List<TeacherResponse> responses = new ArrayList<>();
        for (Teacher teacher : teachers) {
            responses.add(viewTeacher(teacher));
        }
        return responses;
    }
}
