package ita.softserve.course_evaluation_analytics.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FeedbackRequest {


    private long id;

    private String feedbackDescription;

    public long getId() {
        return id;
    }
}
