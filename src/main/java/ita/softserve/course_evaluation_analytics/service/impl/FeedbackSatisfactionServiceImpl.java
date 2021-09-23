package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.FeedbackRequest;
import ita.softserve.course_evaluation_analytics.entity.FeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.repository.AnalystRepository;
import ita.softserve.course_evaluation_analytics.service.FeedbackSatisfactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackSatisfactionServiceImpl implements FeedbackSatisfactionService {

      private final AnalystRepository analystRepository;

         FeedbackSatisfactionServiceImpl(AnalystRepository analystRepository) {
                this.analystRepository = analystRepository;
    }


      public List<FeedbackSatisfaction> getSatisfaction (){
          List<FeedbackSatisfaction> feedbackSatisfaction=new ArrayList<FeedbackSatisfaction>();
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
