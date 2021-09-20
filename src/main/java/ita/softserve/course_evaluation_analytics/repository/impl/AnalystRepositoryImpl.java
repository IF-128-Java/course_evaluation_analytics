package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import ita.softserve.course_evaluation_analytics.mapper.CoursesMapper;
import ita.softserve.course_evaluation_analytics.mapper.FeedbackRequestMapper;
import ita.softserve.course_evaluation_analytics.repository.AnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AnalystRepositoryImpl implements AnalystRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(@Qualifier("datasource") final DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Course> getAllCourses() {
        String SQL = "SELECT c.id, c.course_name FROM course c ";
        return  jdbcTemplate.query(SQL, new CoursesMapper());


    }

    @Override
    public List <FeedbackRequest>getFeedbackRequests(){

        String SQL = "SELECT cfr.id, cfr.feedback_description FROM course_feedback_request cfr ";

        return jdbcTemplate.query(SQL, new FeedbackRequestMapper() );

    }

    @Override
    public List <FeedbackRequest>getFeedbackRequestByCourse(long id){
        BigDecimal bigDecId = new BigDecimal(id);
        String SQL = "SELECT cfr.id, cfr.feedback_description FROM course_feedback_request cfr "+
        "WHERE cfr.course_id = ? ";
        return jdbcTemplate.query(SQL, new Object[] { bigDecId }, new FeedbackRequestMapper() );

    }

    @Override
    public List <FeedbackRequest>getFeedbackRequestByCourseAndMonth(long id, int month, int year){
        BigDecimal bigDecId = new BigDecimal(id);
        Integer monthDb = new Integer(month);
        Integer yearDb = new Integer(year);
        String SQL = "SELECT cfr.id, cfr.feedback_description FROM course_feedback_request cfr "+
                "WHERE cfr.course_id = ? AND YEAR(cfr.start_date)=?2 AND MONTH(cfr.start_date)=?1 OR MONTH(cfr.end_date)=?1 ";
        return jdbcTemplate.query(SQL, new Object[] { bigDecId, monthDb, yearDb }, new FeedbackRequestMapper() );

    }

    @Override
    public Integer getRate( long id) {
        BigDecimal bigDecId = new BigDecimal(id);
        String SQL = "SELECT AVG(atf.rate) FROM answer_to_feedbacks atf "+
                "INNER JOIN course_feedback cf ON atf.feedback_id=cf.id "+
                "INNER JOIN course_feedback_request cfr ON cf.feedback_request_id=cfr.id "+
                "WHERE cfr.id=?";

        return jdbcTemplate.queryForObject(SQL, new Object[] { bigDecId }, Integer.class );
    }



}
