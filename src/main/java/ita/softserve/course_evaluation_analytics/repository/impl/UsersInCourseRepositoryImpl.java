package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.UsersInCourse;
import ita.softserve.course_evaluation_analytics.mapper.UsersInCourseMapper;
import ita.softserve.course_evaluation_analytics.repository.UsersInCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UsersInCourseRepositoryImpl implements UsersInCourseRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<UsersInCourse> countUsersInCourse() {
        String sql = "SELECT course_name, COUNT(u.id) AS users_in_course FROM course c INNER JOIN course_group cg on c.id = cg.course_id " +
                "INNER JOIN groups g on g.id = cg.group_id INNER JOIN users u on g.id = u.group_id group by course_name";
        return namedParameterJdbcTemplate.query(sql, new UsersInCourseMapper());
    }
}
