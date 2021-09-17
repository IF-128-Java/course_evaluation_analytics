package ita.softserve.course_evaluation_analytics.mapper;


import ita.softserve.course_evaluation_analytics.entity.UsersFeedbacks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersFeedbacksResultSetExtractor implements RowMapper<UsersFeedbacks> {
    private static final String LAST_NAME = "last_name";
    private static final String FIRST_NAME = "first_name";
    private static final String COURSES_FEEDBACKS = "courses_feedbacks";
    private static final String GROUP_ID = "group_id";
    @Override
    public UsersFeedbacks mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UsersFeedbacks(resultSet.getString(LAST_NAME),
                resultSet.getString(FIRST_NAME),
                resultSet.getLong(COURSES_FEEDBACKS),
                resultSet.getLong(GROUP_ID)
                );
    }
}
