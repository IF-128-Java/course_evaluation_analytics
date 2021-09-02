package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.Role;
import ita.softserve.course_evaluation_analytics.entity.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class UsersMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//        Set<Role> roles = Role.values(resultSet.getArray("roles"));
        Users users = new Users(resultSet.getLong("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("email"),
                resultSet.getString("password")
//                resultSet.getObject("roles")
                );
//        users.setId(resultSet.getLong("id"));
//        users.setFirstName(resultSet.getString("firstName"));
//        users.setLastName(resultSet.getString("lastName"));
//        users.setEmail(resultSet.getString("email"));
//        users.setPassword(resultSet.getString("password"));
//        users.setRoles(resultSet.getObject("roles"));
        return users;
    }
}
