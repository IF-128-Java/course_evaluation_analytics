package ita.softserve.course_evaluation_analytics.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ita.softserve.course_evaluation_analytics.entity.Role;
import ita.softserve.course_evaluation_analytics.entity.Users;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class UsersMapper implements RowMapper<Users> {
//        ResultSetExtractor<Map<String, List<String>>> {
//    @Override
//    public Map<String, List<String>> extractData(ResultSet resultSet)
//            throws SQLException, DataAccessException {
//        Map<String, List<String>> data = new LinkedHashMap<>();
//        while (resultSet.next()) {
//            String firstName = resultSet.getString("first_name");
//            data.putIfAbsent("firstName", Collections.singletonList(firstName));
//            String lastName = resultSet.getString("last_name");
//            data.putIfAbsent("lastName", Collections.singletonList(lastName));
//            String email = resultSet.getString("email");
//            data.putIfAbsent("email", Collections.singletonList(email));
//            String password = resultSet.getString("password");
//            data.putIfAbsent("password", Collections.singletonList(password));
//            String roles = resultSet.getString("role_name");
//            data.putIfAbsent(roles, new ArrayList<>());
//        }
////        List<Users> user = new ObjectMapper().convertValue(data, new TypeReference<List<Users>>() {
////        });
//
//        return data;
//    }
//
//
//    public Users mapToUser (Map<String, List<String>> data) {
//        Role role;
//        Users user = new Users();
//        data.forEach((n, col) -> {
//            if (n.equals("firstName")) {
//                col.forEach(user::setFirstName);
//            }
//            if (n.equals("last_name")) {
//                col.forEach(user::setLastName);
//            }
//            if (n.equals("email")) {
//                col.forEach(user::setEmail);
//            }
//            if (n.equals("password")) {
//                col.forEach(user::setPassword);
//            }
//            user.setRoles(List.of(Enum.valueOf(Role.class, n)));
//        });
//        return user;
//    }
    @Override
    public Users mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//        Set<Role> roles = Role.values(resultSet.getArray("roles"));
        Users users = new Users();
//        return new Users(resultSet.getLong("id"),
//                resultSet.getString("firstName"),
//                resultSet.getString("lastName"),
//                resultSet.getString("email"),
//                resultSet.getString("password"),
//                (Set<Role>) resultSet.getObject("roles")
//        );
        users.setId(resultSet.getLong("id"));
        users.setFirstName(resultSet.getString("first_name"));
        users.setLastName(resultSet.getString("last_name"));
        users.setEmail(resultSet.getString("email"));
        users.setPassword(resultSet.getString("password"));
        users.setRoles(List.of(Enum.valueOf(Role.class, resultSet.getString("role_name"))));

        return users;
    }
}
