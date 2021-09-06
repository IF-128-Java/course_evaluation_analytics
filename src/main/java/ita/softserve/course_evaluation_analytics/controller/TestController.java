package ita.softserve.course_evaluation_analytics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/analytics/test")
public class TestController {
    @GetMapping
    public ResponseEntity<?> testEndpoint() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
