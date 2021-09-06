package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.UserRoles;
import ita.softserve.course_evaluation_analytics.service.UserRolesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/analytics")
public class UserRolesController {
    private final UserRolesService userRolesService;

    public UserRolesController(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    public ResponseEntity<List<UserRoles>> getAllUserRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(userRolesService.getAllRolesByUsersId());
    }
}
