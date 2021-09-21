package ita.softserve.course_evaluation_analytics.controller;


import ita.softserve.course_evaluation_analytics.entity.FeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.service.FeedbackSatisfactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/feedbacksatisfaction")
public class FeedbackSatisfactionController {

    private final FeedbackSatisfactionService feedbackSatisfactionService;

    FeedbackSatisfactionController(FeedbackSatisfactionService feedbackSatisfactionService) {
        this.feedbackSatisfactionService = feedbackSatisfactionService;
    }

        @GetMapping("")
            public ResponseEntity<List<FeedbackSatisfaction>> getAllFeedbackSatisfacton(){
        return ResponseEntity.status(HttpStatus.OK).body(feedbackSatisfactionService.getSatisfaction());
        }


}
