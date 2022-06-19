package kuba.exam_project.mapper.editMapper;

import kuba.exam_project.dto.request.TeacherRequest;
import kuba.exam_project.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherEditMapper {

    public Teacher creat(TeacherRequest request) {
        if (request == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setName(request.getName());
        teacher.setSurname(request.getSurname());
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest request) {
        teacher.setName(request.getName());
        teacher.setSurname(request.getSurname());
    }
}
