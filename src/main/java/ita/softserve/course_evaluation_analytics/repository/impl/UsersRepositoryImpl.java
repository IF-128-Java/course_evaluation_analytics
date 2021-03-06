package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.Role;
import ita.softserve.course_evaluation_analytics.entity.Users;
import ita.softserve.course_evaluation_analytics.mapper.RoleRowMapper;
import ita.softserve.course_evaluation_analytics.mapper.UsersMapper;
import ita.softserve.course_evaluation_analytics.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(@Qualifier("datasource") final DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Role> findRoleByUserEmail(String email) {
        String sql = "SELECT r.id FROM role r INNER JOIN user_roles ur on r.id = ur.role_id INNER JOIN users u on " +
                "ur.user_id = u.id WHERE u.email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new RoleRowMapper());

    }

    public Optional<Users> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email);
        return Optional.ofNullable(DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(sql, namedParameters, new UsersMapper())));
    }
    
    @Override
    public Users findUserById(Long id) {
        String sql = "SELECT u.* from users as u where u.id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(sql, namedParameters, new UsersMapper()));
    }
    
}
