package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.UsersInCourse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersInCourseMapper implements RowMapper<UsersInCourse> {
    @Override
    public UsersInCourse mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UsersInCourse(resultSet.getString("course_name"),
                resultSet.getLong("users_in_course"));
    }
}
