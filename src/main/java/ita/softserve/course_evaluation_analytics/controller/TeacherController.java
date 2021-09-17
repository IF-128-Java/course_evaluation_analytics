package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.TeacherRateCounter;
import ita.softserve.course_evaluation_analytics.service.TeacherCounterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/analytics/teacher")
public class TeacherController {
	private final TeacherCounterService teacherCounterService;
	
	public TeacherController(TeacherCounterService teacherCounterService) {
		this.teacherCounterService = teacherCounterService;
	}
	
	
	@GetMapping("/rate")
	public ResponseEntity<List<TeacherRateCounter>> getTeacherRate() {
		return ResponseEntity.status(HttpStatus.OK).body(teacherCounterService.getTeacherRate());
	}
}
