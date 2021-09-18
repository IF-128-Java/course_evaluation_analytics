package ita.softserve.course_evaluation_analytics.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackSatisfaction {

    private String FeedbackName;
    private int  satisfaction;

}
