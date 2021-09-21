package ita.softserve.course_evaluation_analytics.mapper;

import ita.softserve.course_evaluation_analytics.entity.FeedbackInfo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class FeedbackInfoRowMapper implements RowMapper<FeedbackInfo> {
    @Override
    public FeedbackInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        return FeedbackInfo.builder()
                .feedbackDescription(resultSet.getString("feedback_description"))
                .startDate(LocalDateTime.parse(resultSet.getString("start_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .endDate(LocalDateTime.parse(resultSet.getString("end_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .status(resultSet.getString("status"))
                .courseName(resultSet.getString("course_name"))
                .questionText(resultSet.getString("question_text"))
                .rate(resultSet.getInt("rate"))
                .studentId(resultSet.getLong("student_id"))
                .email(resultSet.getString("email"))
                .build();

    }
}
