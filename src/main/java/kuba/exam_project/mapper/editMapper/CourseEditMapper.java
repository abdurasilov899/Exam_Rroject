package kuba.exam_project.mapper.editMapper;

import kuba.exam_project.dto.request.CourseRequest;
import kuba.exam_project.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseEditMapper {

    public Course creat(CourseRequest courseRequest) {
        if (courseRequest == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());

        return course;
    }

    public void update(Course course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
    }
}
