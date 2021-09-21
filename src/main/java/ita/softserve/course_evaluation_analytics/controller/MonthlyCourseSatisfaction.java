package ita.softserve.course_evaluation_analytics.controller;


import ita.softserve.course_evaluation_analytics.entity.CourseSatisfactionByMonth;
import ita.softserve.course_evaluation_analytics.service.CourseSatisfactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/monthlycoursesatisfaction")
public class MonthlyCourseSatisfaction {
    private final CourseSatisfactionService courseSatisfactionService;

    MonthlyCourseSatisfaction(CourseSatisfactionService courseSatisfactionService) {
        this.courseSatisfactionService = courseSatisfactionService; }

    @GetMapping("/{id}")
    public ResponseEntity<List<CourseSatisfactionByMonth>> getAllCoursesatisfaction(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseSatisfactionService.getMonthlyCourseSatisfaction(id));
    }
}
