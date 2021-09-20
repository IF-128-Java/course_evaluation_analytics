package ita.softserve.course_evaluation_analytics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    private long id;
    @JsonProperty("x")
    private String groupName;
    @JsonProperty("y")
    private long coursesInGroup;
    @JsonProperty("color")
    private String COLOR = "#03884c";
    @JsonProperty("quarters")
    private List<UsersFeedbacks> usersFeedbacks;
}
