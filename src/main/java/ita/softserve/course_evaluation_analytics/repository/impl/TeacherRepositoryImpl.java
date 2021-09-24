package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.TeacherQuestionRate;
import ita.softserve.course_evaluation_analytics.mapper.TeacherQuestionRateMapper;
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
	
	@Autowired
	public void setDataSource(@Qualifier("datasource") final DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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
		String sql = "SELECT u.id FROM users AS u INNER JOIN user_roles ur ON u.id = ur.user_id WHERE ur.role_id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1L);
		return namedParameterJdbcTemplate.queryForList(sql, namedParameters, Long.class);
	}
	
	@Override
	public List<Long> getAllTeacherCourses(Long teacherId) {
		String sql = "SELECT c.id FROM course as c WHERE teacher_id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", teacherId);
		return namedParameterJdbcTemplate.queryForList(sql, namedParameters, Long.class);
	}
	
	@Override
	public List<TeacherQuestionRate> getQuestionPatternRateByTeacherId(Long teacherId) {
		String sql = "SELECT q.id as question_id, q.question_text as question_text, q.is_pattern as is_pattern, AVG(atf.rate) as rate " +
				             "FROM question q " +
				             "INNER JOIN answer_to_feedbacks atf on q.id = atf.question_id " +
				             "INNER JOIN course_feedback cf on cf.id = atf.feedback_id " +
				             "INNER JOIN course_feedback_request cfr ON cf.feedback_request_id=cfr.id " +
				             "INNER JOIN course c ON c.id = cfr.course_id " +
				             "WHERE c.teacher_id=:id and q.is_pattern = true " +
				             "GROUP BY q.id, q.question_text, q.is_pattern";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", teacherId);
		return namedParameterJdbcTemplate.query(sql, namedParameters, new TeacherQuestionRateMapper());
	}
}