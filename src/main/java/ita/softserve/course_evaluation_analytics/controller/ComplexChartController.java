package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.GroupsCourses;
import ita.softserve.course_evaluation_analytics.service.impl.ComplexChartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin/analytics/complex-chart")
public class ComplexChartController {
    private final ComplexChartServiceImpl complexChartService;

    @GetMapping
    private ResponseEntity<List<GroupsCourses>> getCoursesAndFeedbacksNumberInGroups() {
        return ResponseEntity.status(HttpStatus.OK).body(complexChartService.countGroupsCoursesAndUsersFeedbacks());
    }
}
