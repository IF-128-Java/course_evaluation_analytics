package ita.softserve.course_evaluation_analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackInfo {

    private String feedbackDescription;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private String courseName;
    private String questionText;
    private int rate;
    private long studentId;
    private String email;

}
