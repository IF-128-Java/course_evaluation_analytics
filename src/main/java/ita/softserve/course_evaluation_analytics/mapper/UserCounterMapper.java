package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.Users;
import ita.softserve.course_evaluation_analytics.entity.UsersCounter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCounterMapper implements RowMapper<UsersCounter> {
    @Override
    public UsersCounter mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UsersCounter(resultSet.getLong("admin_roles"),
                resultSet.getLong("teacher_roles"),
                resultSet.getLong("student_roles"),
                resultSet.getLong("no_roles"));
    }
}
