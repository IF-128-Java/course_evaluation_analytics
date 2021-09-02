package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.mapper.UsersMapper;
import ita.softserve.course_evaluation_analytics.entity.Users;
import ita.softserve.course_evaluation_analytics.repository.UsersRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UsersRepositoryImpl implements UsersRepository {

    public JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Users findByEmail(String email) {
        String sql = "SELECT * FROM users u WHERE u.email = ?1";
        return jdbcTemplate.queryForObject(sql, new UsersMapper(), email);
    }
}
