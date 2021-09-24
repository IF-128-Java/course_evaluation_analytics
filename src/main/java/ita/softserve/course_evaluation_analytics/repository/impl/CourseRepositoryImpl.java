package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(@Qualifier("datasource") final DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public Float getCourseRateByCourseId(long courseId) {
			String sql = "SELECT AVG(atf.rate) as rate FROM answer_to_feedbacks atf " +
					             "INNER JOIN course_feedback cf ON atf.feedback_id=cf.id " +
					             "INNER JOIN course_feedback_request cfr ON cf.feedback_request_id=cfr.id " +
					             "INNER JOIN course c ON c.id = cfr.course_id WHERE c.id = :id";
			SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", courseId);
			return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Float.class);
		
	}
}