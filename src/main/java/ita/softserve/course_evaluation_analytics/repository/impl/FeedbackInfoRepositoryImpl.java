package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.FeedbackInfo;
import ita.softserve.course_evaluation_analytics.mapper.FeedbackInfoRowMapper;
import ita.softserve.course_evaluation_analytics.repository.FeedbackInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class FeedbackInfoRepositoryImpl implements FeedbackInfoRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<FeedbackInfo> findFeedbackInfoByCourseId(Long id) {

        String sql = "SELECT feedback_description, start_date, end_date, status,course_name,q.question_text,atf.rate,student_id,u.email FROM (SELECT cfr.feedback_description, cfr.id,cfr.start_date,cfr.end_date,frs.status,c.course_name,cfrq.question_id,cf.id feedback_id,cf.student_id FROM course_feedback_request cfr left join feedback_request_status frs on cfr.status = frs.id left join course c on cfr.course_id = c.id left join course_feedback_request_question cfrq on cfr.id = cfrq.feedback_request_id left join course_feedback cf on cfr.id = cf.feedback_request_id where c.id = :course_id) temp left join question q on q.id = temp.question_id left join answer_to_feedbacks atf on atf.question_id = temp.question_id and atf.feedback_id = temp.feedback_id left join users u on u.id = temp.student_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("course_id", id);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new FeedbackInfoRowMapper());
    }
}
