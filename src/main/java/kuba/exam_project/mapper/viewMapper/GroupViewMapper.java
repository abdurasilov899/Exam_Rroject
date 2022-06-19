package kuba.exam_project.mapper.viewMapper;

import kuba.exam_project.dto.response.GroupResponse;
import kuba.exam_project.entity.Group;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class GroupViewMapper {

    public GroupResponse viewGroup(Group group) {
        if (group == null) {
            return null;
        }
        GroupResponse response =
                new GroupResponse();
        response.setGroupName(group.getGroupName());
        response.setStart(LocalDate.EPOCH.format(DateTimeFormatter.ofPattern("Date", Locale.getDefault())));
        response.setFinish(LocalDate.EPOCH.format(DateTimeFormatter.ofPattern("Date", Locale.getDefault())));
        return response;
    }

    public List<GroupResponse> view(List<Group> groups) {
        List<GroupResponse> responses = new ArrayList<>();
        for (Group group : groups) {
            responses.add(viewGroup(group));
        }
        return responses;
    }
}
