package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(@Qualifier("datasource") final DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Optional<Float> getTeachersRate(Long teacherId) {
		String sql = "SELECT AVG(atf.rate) FROM answer_to_feedbacks atf " +
				             "INNER JOIN course_feedback cf ON atf.feedback_id=cf.id " +
				             "INNER JOIN course_feedback_request cfr ON cf.feedback_request_id=cfr.id " +
				             "INNER JOIN course c ON c.id = cfr.course_id WHERE c.teacher_id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", teacherId);
		return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Float.class));
	}
	
	@Override
	public List<Long> getAllTeacher() {
		String sql = "SELECT u.id FROM users AS u INNER JOIN user_roles ur ON u.id = ur.user_id WHERE ur.role_id = 1";
		return jdbcTemplate.queryForList(sql, Long.class);
	}
	
}
