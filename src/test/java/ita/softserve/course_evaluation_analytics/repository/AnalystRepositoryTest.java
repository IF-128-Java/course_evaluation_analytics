package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.config.AppConfig;
import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AnalystRepositoryTest {

    @Autowired
    private AnalystRepository analystRepository;


    @Test
    public void getAllCourseTest() {

        List<Course> receiptedCourses = analystRepository.getAllCourses();
        assertEquals(2, receiptedCourses.size());
    }

    @Test
    public void getFeedbackRequests(){
        List<FeedbackRequest> actual = analystRepository.getFeedbackRequests();
        assertEquals(2, actual.size());
        assertEquals("phyton", actual.get(1).getFeedbackDescription());
    }

    @Test
    public void getFeedbackRequestByCourseTest() {
        List<FeedbackRequest> actual = analystRepository.getFeedbackRequestByCourse(1);
        assertEquals(1, actual.size());
        assertEquals("SQL", actual.get(0).getFeedbackDescription());
         }

    @Test
    public void getFeedbackRequestByCourseTest2() {
        List<FeedbackRequest> actual = analystRepository.getFeedbackRequestByCourse(2);
        assertEquals(1, actual.size());
        assertEquals("phyton", actual.get(0).getFeedbackDescription());
    }

    @Test
    public void getFeedbackRequestByCourseAndMonthTest(){
        List<FeedbackRequest> actual = analystRepository.getFeedbackRequestByCourseAndMonth(1, 2, 2021);
        assertEquals(1, actual.size());
        assertEquals("SQL", actual.get(0).getFeedbackDescription());
    }

    @Test
    public void getRateTest(){
        Integer actual = analystRepository.getRate(1);
        assertEquals(5, actual);
    }
}