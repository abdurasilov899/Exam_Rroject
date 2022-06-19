package kuba.exam_project.mapper.viewMapper;

import kuba.exam_project.dto.response.CourseResponse;
import kuba.exam_project.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Course course) {
        if (course == null) {
            return null;
        }
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        return courseResponse;
    }

    public List<CourseResponse> view(List<Course> courses) {
        List<CourseResponse> responses = new ArrayList<>();
        for (Course course : courses) {
            responses.add(viewCourse(course));
        }
        return responses;
    }
}
