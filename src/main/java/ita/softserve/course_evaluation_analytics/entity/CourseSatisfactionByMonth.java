package ita.softserve.course_evaluation_analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSatisfactionByMonth {

    private String monthName;
    private int rate;
}
