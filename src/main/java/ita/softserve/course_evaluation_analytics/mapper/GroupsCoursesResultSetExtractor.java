package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.GroupsCourses;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupsCoursesResultSetExtractor implements RowMapper<GroupsCourses> {
    @Override
    public GroupsCourses mapRow(ResultSet resultSet, int i) throws SQLException {
        return new GroupsCourses(resultSet.getLong("id"),
                resultSet.getString("group_name"),
                resultSet.getLong("groups_courses"));
    }
}
