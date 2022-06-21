package kuba.exam_project.mapper.editMapper;

import kuba.exam_project.dto.request.GroupRequest;
import kuba.exam_project.entity.Group;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class GroupEditMapper {

    public Group creat(GroupRequest request) {
        if (request == null) {
            return null;
        }
        Group group = new Group();
        group.setGroupName(request.getGroupName());
        group.setStart(request.getStart());
        group.setFinish(request.getFinish());
        return group;
    }

    public void update(Group group, GroupRequest request) {
        group.setGroupName(request.getGroupName());
        group.setStart(request.getStart());
        group.setFinish(request.getFinish());
    }
}
