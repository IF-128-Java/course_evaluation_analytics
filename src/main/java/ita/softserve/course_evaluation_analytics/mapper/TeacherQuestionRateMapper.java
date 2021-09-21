package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.TeacherQuestionRate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TeacherQuestionRateMapper implements RowMapper<TeacherQuestionRate> {
	@Override
	public TeacherQuestionRate mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		TeacherQuestionRate teacherQuestionRate = new TeacherQuestionRate();
		teacherQuestionRate.setQuestionId(resultSet.getLong("question_id"));
		teacherQuestionRate.setQuestionText(resultSet.getString("question_text"));
		teacherQuestionRate.setRate(resultSet.getFloat("rate"));
		return teacherQuestionRate;
	}
	
}




