package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.Role;
import ita.softserve.course_evaluation_analytics.entity.Users;
import ita.softserve.course_evaluation_analytics.mapper.RoleRowMapper;
import ita.softserve.course_evaluation_analytics.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Autowired
    public void setDataSource(final DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Role> findRoleByUserEmail(String email) {
        String sql = "SELECT r.id FROM role r inner join user_roles ur on r.id = ur.role_id inner join users u on ur.user_id = u.id where u.email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email);
        List<Role> roles = namedParameterJdbcTemplate.query(sql, namedParameters, new RoleRowMapper());
        return roles;

    }

    public Optional<Users> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email);
        Optional<Users> user = Optional.ofNullable(DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(sql, namedParameters, new UsersMapper())));
        return user;
    }
}
