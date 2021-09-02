package ita.softserve.course_evaluation_analytics.controller;


import ita.softserve.course_evaluation_analytics.entity.CourseFeedbackSatisfaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
        @RequestMapping("api/v1/coursesatisfaction")
public class CourseSatisfactionController {
          CourseFeedbackSatisfaction courseFeedbackSatisfaction;
    public CourseSatisfactionController(CourseFeedbackSatisfaction courseFeedbackSatisfaction) { this.courseFeedbackSatisfaction = courseFeedbackSatisfaction; }


       public ResponseEntity<List<CourseFeedbackSatisfaction>> getAllCoursesatisfation(){
           return ResponseEntity.status(HttpStatus.OK).body(courseFeedbackSatisfaction.getSatisfactions());
       }

       }
}
