package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.UsersCounter;
import ita.softserve.course_evaluation_analytics.service.UsersCounterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/analytics")
public class UsersCounterController {

    private final UsersCounterService usersCounterService;

    public UsersCounterController(UsersCounterService usersCounterService) {
        this.usersCounterService = usersCounterService;
    }

    @GetMapping("/users-roles")
    public ResponseEntity<List<UsersCounter>> allUsersByRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(usersCounterService.countUsersByRoles());
    }
}
