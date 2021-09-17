package ita.softserve.course_evaluation_analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupsCourses {
    public GroupsCourses(long id, String group_name, long groups_courses) {
        this.id = id;
        this.group_name = group_name;
        this.groups_courses = groups_courses;
    }

    private long id;
    private String group_name;
    private long groups_courses;
    private List<UsersFeedbacks> users_feedbacks;
}
