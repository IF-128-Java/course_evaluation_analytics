package ita.softserve.course_evaluation_analytics.repository.impl;


import ita.softserve.course_evaluation_analytics.entity.UsersCounter;
import ita.softserve.course_evaluation_analytics.mapper.UserCounterMapper;
import ita.softserve.course_evaluation_analytics.repository.UsersCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UsersCounterRepositoryImpl implements UsersCounterRepository {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<UsersCounter> countUserRoles() {
        String sql = "SELECT COUNT(user_id) FILTER ( WHERE  role_id = 2) AS admin_roles, COUNT(user_id) FILTER " +
                "( WHERE  role_id = 1) AS teacher_roles, COUNT(user_id) FILTER ( WHERE role_id = 0) AS student_roles,  " +
                "COUNT( DISTINCT id) - COUNT(DISTINCT user_id) AS no_roles FROM user_roles ur RIGHT JOIN users u on ur.user_id = u.id";
        return namedParameterJdbcTemplate.query(sql, new UserCounterMapper());
    }

}
