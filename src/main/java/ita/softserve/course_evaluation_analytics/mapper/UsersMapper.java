package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.Users;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UsersMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Users users = new Users();
        users.setId(resultSet.getLong("id"));
        users.setFirstName(resultSet.getString("first_name"));
        users.setLastName(resultSet.getString("last_name"));
        users.setEmail(resultSet.getString("email"));
        users.setPassword(resultSet.getString("password"));
        return users;
    }
}
