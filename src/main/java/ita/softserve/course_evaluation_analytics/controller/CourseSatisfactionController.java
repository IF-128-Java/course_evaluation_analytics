package ita.softserve.course_evaluation_analytics.controller;


import ita.softserve.course_evaluation_analytics.entity.CourseFeedbackSatisfaction;
import ita.softserve.course_evaluation_analytics.service.CourseSatisfactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/coursesatisfaction")
public class CourseSatisfactionController {

    private final CourseSatisfactionService courseSatisfactionService;

    CourseSatisfactionController(CourseSatisfactionService courseSatisfactionService) {
       this.courseSatisfactionService = courseSatisfactionService; }

    @GetMapping("")
    public ResponseEntity<List<CourseFeedbackSatisfaction>> getAllCoursesatisfaction(){
        return ResponseEntity.status(HttpStatus.OK).body(courseSatisfactionService.getSatisfactions());
    }

}

