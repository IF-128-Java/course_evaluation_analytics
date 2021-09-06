package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.Users;
import ita.softserve.course_evaluation_analytics.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl {

    private static final String SQL_GET_USERS_ROLES = "SELECT u.id, u.first_name, u.last_name, u.email, u.password, ur.role_id, r.role_name FROM users u LEFT JOIN user_roles ur on u.id = ur.user_id LEFT JOIN role r on r.id = ur.role_id WHERE u.email = :email";
    private DataSource dataSource;
//    NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    public void setDataSource (DataSource dataSource) {
        this.dataSource = dataSource;
    }
    private UsersMapper usersMapper;

    public Optional<Users> findByEmail(String email) {
//        String sql = "SELECT u.id, u.first_name, u.last_name, ur.role_id, r.role_name FROM users u LEFT JOIN user_roles ur on u.id = ur.user_id LEFT JOIN role r on r.id = ur.role_id WHERE u.email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return Optional.of((Users) namedParameterJdbcTemplate.query(SQL_GET_USERS_ROLES, namedParameters, new UsersMapper()));
    }
}
