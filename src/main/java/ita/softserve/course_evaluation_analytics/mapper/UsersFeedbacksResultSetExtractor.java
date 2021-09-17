package ita.softserve.course_evaluation_analytics.mapper;


import ita.softserve.course_evaluation_analytics.entity.UsersFeedbacks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersFeedbacksResultSetExtractor implements RowMapper<UsersFeedbacks> {
    @Override
    public UsersFeedbacks mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UsersFeedbacks(resultSet.getString("last_name"),
                resultSet.getString("first_name"),
                resultSet.getLong("courses_feedbacks"),
                resultSet.getLong("group_id")
                );
    }
}
