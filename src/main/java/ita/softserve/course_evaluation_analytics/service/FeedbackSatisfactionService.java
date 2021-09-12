package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.CourseFeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import ita.softserve.course_evaluation_analytics.entity.FeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.repository.AnalystRepository;

import java.util.ArrayList;
import java.util.List;

public class FeedbackSatisfactionService {

      AnalystRepository analystRepository;

      List<FeedbackSatisfaction> feedbackSatisfaction=new ArrayList<FeedbackSatisfaction>();
      public List<FeedbackSatisfaction> getSatisfaction (){
                     feedbackSatisfaction.clear();
                  List<FeedbackRequest> feedbackRequests = analystRepository.getFeedbackRequests();
                  System.out.print(feedbackRequests);
                  if(!feedbackRequests.isEmpty()) {
                        for (FeedbackRequest feedbackRequest : feedbackRequests) {
                              Integer rate = analystRepository.getRate(feedbackRequest.getId());
                              if(rate==null){rate=0;}
                              System.out.print(rate);
                              feedbackSatisfaction.add(new FeedbackSatisfaction( feedbackRequest.getFeedbackDescription(), rate));
                        }
                  }
                  else  feedbackSatisfaction.add(new FeedbackSatisfaction( "", 0 ));
                  return feedbackSatisfaction;
            }




}
