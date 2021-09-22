package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.UserInfo;
import ita.softserve.course_evaluation_analytics.mapper.UserInfoRowMapper;
import ita.softserve.course_evaluation_analytics.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserInfoRepositoryImpl implements UserInfoRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<UserInfo> findUserInfoByRoleId() {
        String sql = "SELECT u.first_name, u.last_name, u.email,g.group_name, ur.role_name\n" +
                "FROM users u\n" +
                "LEFT JOIN groups g on u.group_id = g.id\n" +
                "LEFT JOIN (SELECT r.id, ur.user_id , r.role_name from role r left join user_roles ur  on r.id = ur.role_id) ur on ur.user_id = u.id\n";
        return namedParameterJdbcTemplate.query(sql, new UserInfoRowMapper());
    }
}
