package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.CourseFeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import ita.softserve.course_evaluation_analytics.repository.AnalystRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service

public class CourseSatisfactionService {

      AnalystRepository analystRepository;

      CourseSatisfactionService(AnalystRepository analystRepository){
          this.analystRepository=analystRepository;
      }

    public List<CourseFeedbackSatisfaction> getSatisfactions(){

        List<CourseFeedbackSatisfaction> coursesFeedbackSatisfaction = null;

        List <Course> courses = analystRepository.getAllCourses();

      /*   for (Course course : courses) {
            for(FeedbackRequest feedbackRequest : course.getFeedbackRequest()) {
                          Integer rate = analystRepository.getRate(course, feedbackRequest);
                          coursesFeedbackSatisfaction.add(new CourseFeedbackSatisfaction((int) course.getId(), feedbackRequest.getId(), rate));
            }
*/
        return new ArrayList<CourseFeedbackSatisfaction>((Collection<? extends CourseFeedbackSatisfaction>) new CourseFeedbackSatisfaction("Sql", "literatura", 5));

    }

}