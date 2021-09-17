package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.GroupsCourses;
import ita.softserve.course_evaluation_analytics.entity.UsersFeedbacks;
import ita.softserve.course_evaluation_analytics.mapper.GroupsCoursesResultSetExtractor;
import ita.softserve.course_evaluation_analytics.mapper.UsersFeedbacksResultSetExtractor;
import ita.softserve.course_evaluation_analytics.repository.ComplexChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ComplexChartRepositoryImpl implements ComplexChartRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<GroupsCourses> getCoursesInGroups() {
        String sql = "SELECT id, group_name, COUNT(cg.course_id) AS groups_courses FROM groups INNER JOIN " +
                "course_group cg on groups.id = cg.group_id group by id";
        return namedParameterJdbcTemplate.query(sql, new GroupsCoursesResultSetExtractor());
    }

    @Override
    public List<UsersFeedbacks> getFeedbacksFromUser() {
        String sql = "SELECT last_name, first_name, COUNT(cf.student_id) AS courses_feedbacks, group_id FROM users u " +
                "LEFT JOIN course_feedback cf on u.id = cf.student_id WHERE group_id NOTNULL group by u.id";
        return namedParameterJdbcTemplate.query(sql, new UsersFeedbacksResultSetExtractor());
    }
}
