package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.Course;
import ita.softserve.course_evaluation_analytics.entity.CourseFeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import ita.softserve.course_evaluation_analytics.entity.FeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.repository.AnalystRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackSatisfactionService {

      AnalystRepository analystRepository;

         FeedbackSatisfactionService(AnalystRepository analystRepository) {
                this.analystRepository = analystRepository;
    }

      List<FeedbackSatisfaction> feedbackSatisfaction=new ArrayList<FeedbackSatisfaction>();
      public List<FeedbackSatisfaction> getSatisfaction (){
                     feedbackSatisfaction.clear();
                  List<FeedbackRequest> feedbackRequests = analystRepository.getFeedbackRequests();

                  if(!feedbackRequests.isEmpty()) {
                        for (FeedbackRequest feedbackRequest : feedbackRequests) {
                              Integer rate = analystRepository.getRate(feedbackRequest.getId());
                              if(rate==null){rate=0;}

                              feedbackSatisfaction.add(new FeedbackSatisfaction( feedbackRequest.getFeedbackDescription(), rate));
                        }
                  }
                  else  feedbackSatisfaction.add(new FeedbackSatisfaction( "", 0 ));
                  return feedbackSatisfaction;
            }




}
