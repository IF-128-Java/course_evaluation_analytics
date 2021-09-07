package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class AnalystRepository {

        public List<Course> getAllCourses(){ return null; }

        public Integer getRate(Course course, FeedbackRequest feedbackRequest) {return null;}
}
