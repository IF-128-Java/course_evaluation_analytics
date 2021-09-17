package ita.softserve.course_evaluation_analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersFeedbacks {
    private String last_name;
    private String first_name;
    private long courses_feedbacks;
    private long group_id;
}
