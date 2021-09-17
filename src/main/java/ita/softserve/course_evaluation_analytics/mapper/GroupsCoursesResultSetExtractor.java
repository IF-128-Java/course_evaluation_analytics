package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.GroupsCourses;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupsCoursesResultSetExtractor implements RowMapper<GroupsCourses> {
    private static final String ID = "id";
    private static final String GROUP_NAME = "group_name";
    private static final String GROUPS_COURSES = "groups_courses";
    @Override
    public GroupsCourses mapRow(ResultSet resultSet, int i) throws SQLException {
        return new GroupsCourses(resultSet.getLong(ID),
                resultSet.getString(GROUP_NAME),
                resultSet.getLong(GROUPS_COURSES));
    }
}
