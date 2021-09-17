package ita.softserve.course_evaluation_analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupsCourses {
    public GroupsCourses(long id, String groupName, long coursesInGroup) {
        this.id = id;
        this.groupName = groupName;
        this.coursesInGroup = coursesInGroup;
    }

    private long id;
    private String groupName;
    private long coursesInGroup;
    private List<UsersFeedbacks> usersFeedbacks;
}
