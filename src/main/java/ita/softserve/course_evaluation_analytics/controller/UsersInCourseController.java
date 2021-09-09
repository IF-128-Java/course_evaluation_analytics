package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.UsersCounter;
import ita.softserve.course_evaluation_analytics.entity.UsersInCourse;
import ita.softserve.course_evaluation_analytics.service.UsersInCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/analytics")
public class UsersInCourseController {
    private final UsersInCourseService usersInCourseService;

    public UsersInCourseController(UsersInCourseService usersInCourseService) {
        this.usersInCourseService = usersInCourseService;
    }

    @GetMapping("/users-in-course")
    public ResponseEntity<List<UsersInCourse>> getNumberOfUsersByGroups() {
        return ResponseEntity.status(HttpStatus.OK).body(usersInCourseService.countUsersInCourse());
    }
}
