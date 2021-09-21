package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import ita.softserve.course_evaluation_analytics.entity.Users;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FeedbackRequestMapper implements RowMapper<FeedbackRequest> {
    @Override
    public FeedbackRequest mapRow(ResultSet resultSet, int rowNum) throws  SQLException{
        FeedbackRequest feedbackRequest = new FeedbackRequest();
        feedbackRequest.setId(resultSet.getLong("id"));
        feedbackRequest.setFeedbackDescription(resultSet.getString("feedback_description"));
        return  feedbackRequest;
    }

}




