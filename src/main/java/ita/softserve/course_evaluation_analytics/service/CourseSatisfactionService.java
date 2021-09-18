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

    CourseSatisfactionService(AnalystRepository analystRepository) {
        this.analystRepository = analystRepository;
    }

    public List<CourseFeedbackSatisfaction> getSatisfactions() {

        List<CourseFeedbackSatisfaction> coursesFeedbackSatisfaction=new ArrayList<CourseFeedbackSatisfaction>();

        List<Course> courses = analystRepository.getAllCourses();

        for (Course course : courses) {
            List<FeedbackRequest> feedbackRequests = analystRepository.getFeedbackRequestByCourse(course.getId());

                if(!feedbackRequests.isEmpty()) {
                    for (FeedbackRequest feedbackRequest : feedbackRequests) {
                        Integer rate = analystRepository.getRate(feedbackRequest.getId());
                        if(rate==null){rate=0;}

                        coursesFeedbackSatisfaction.add(new CourseFeedbackSatisfaction(course.getCourseName(), feedbackRequest.getFeedbackDescription(), rate));
                    }
                }
                   else  coursesFeedbackSatisfaction.add(new CourseFeedbackSatisfaction("", "", 0 ));
        }


        return coursesFeedbackSatisfaction;

        
    }
}