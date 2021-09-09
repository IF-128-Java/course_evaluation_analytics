package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AnalystRepository {

        public List<Course> getAllCourses();

        public List<FeedbackRequest> getFeedbackRequestByCourse(long id);

        public Integer getRate(FeedbackRequest feedbackRequest) ;
}
