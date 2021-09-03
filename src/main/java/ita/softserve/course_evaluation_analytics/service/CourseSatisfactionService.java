package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.CourseFeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import ita.softserve.course_evaluation_analytics.repository.AnalystRepository;

import java.util.List;

public class CourseSatisfactionService {

      AnalystRepository analystRepository;

    public List<CourseFeedbackSatisfaction> getSatisfactions(){

        List<CourseFeedbackSatisfaction> coursesFeedbackSatisfaction = null;

        List <Course> courses = analystRepository.getAllCourses();

         for (Course course : courses) {
            for(FeedbackRequest feedbackRequest : course.getFeedbackRequest()) {
                          Integer rate = analystRepository.getRate(course, feedbackRequest);
                          coursesFeedbackSatisfaction.add(new CourseFeedbackSatisfaction(course.getId(), feedbackRequest.getId(), rate));
            }

         }
        return coursesFeedbackSatisfaction;

    }

}