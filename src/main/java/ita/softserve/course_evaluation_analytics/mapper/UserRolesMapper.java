package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.UserRoles;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRolesMapper implements RowMapper <UserRoles> {
    @Override
    public UserRoles mapRow(ResultSet resultSet, int i) throws SQLException {
        UserRoles roles = new UserRoles();
        roles.setRoleId(resultSet.getLong("role_id"));
        roles.setUserId(resultSet.getLong("user_id"));
        roles.setRoleName(resultSet.getString("role_name"));
        return roles;
    }
}
