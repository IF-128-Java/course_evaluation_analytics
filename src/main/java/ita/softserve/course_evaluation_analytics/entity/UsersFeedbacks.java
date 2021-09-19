package ita.softserve.course_evaluation_analytics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersFeedbacks {
    @JsonProperty("x")
    private String lastName;
    @JsonIgnore
    private String firstName;
    @JsonProperty("y")
    private long coursesFeedbacks;
    @JsonIgnore
    private long groupId;
}
