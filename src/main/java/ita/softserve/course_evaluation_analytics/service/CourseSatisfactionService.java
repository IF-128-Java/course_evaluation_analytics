package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.CourseFeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.entity.CourseSatisfactionByMonth;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import ita.softserve.course_evaluation_analytics.repository.AnalystRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

        List<CourseFeedbackSatisfaction> coursesFeedbackSatisfaction=new ArrayList<>();

        List<Course> courses = analystRepository.getAllCourses();

        for (Course course : courses) {
            List<FeedbackRequest> feedbackRequests = analystRepository.getFeedbackRequestByCourse(course.getId());

                if(!feedbackRequests.isEmpty()) {
                    for (FeedbackRequest feedbackRequest : feedbackRequests) {
                        Integer rate = analystRepository.getRate(feedbackRequest.getId());
                        if(rate==null){rate=0;}

                        coursesFeedbackSatisfaction.add(new CourseFeedbackSatisfaction(course.getId(), course.getCourseName(), feedbackRequest.getFeedbackDescription(), rate));
                    }
                }
                   else  coursesFeedbackSatisfaction.add(new CourseFeedbackSatisfaction(0,"", "", 0 ));
        }


        return coursesFeedbackSatisfaction;

        
    }

    public List<CourseSatisfactionByMonth> getMonthlyCourseSatisfaction (long  courseId){

        List<CourseSatisfactionByMonth> courseSatisfactionByMonth = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for( int i=5;  i>=0; i=i-1){
            LocalDate temperary = today.minus(i, ChronoUnit.MONTHS);
            List<FeedbackRequest> feedbackRequests = analystRepository.getFeedbackRequestByCourseAndMonth(courseId, temperary.getMonthValue(), temperary.getYear());

            if(!feedbackRequests.isEmpty()) {
                int n=0; int  sumRates =0; int avarageRate=0;
                for (FeedbackRequest feedbackRequest : feedbackRequests) {

                    Integer rate = analystRepository.getRate(feedbackRequest.getId());
                    if(rate==null){rate=0;}
                    sumRates = sumRates+rate;
                    n=n+1;


                }
                if(n!=0){avarageRate = sumRates/n;}
                courseSatisfactionByMonth.add(new CourseSatisfactionByMonth(temperary.getMonth().toString(), avarageRate));
            }
              else  courseSatisfactionByMonth.add(new CourseSatisfactionByMonth(temperary.getMonth().toString(), 0));
        }
            return courseSatisfactionByMonth;
    }
}