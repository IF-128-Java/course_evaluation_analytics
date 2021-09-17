package ita.softserve.course_evaluation_analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersFeedbacks {
    private String lastName;
    private String firstName;
    private long coursesFeedbacks;
    private long groupId;
}
