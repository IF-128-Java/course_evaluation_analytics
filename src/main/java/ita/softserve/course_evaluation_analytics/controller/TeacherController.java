package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.TeacherQuestionRate;
import ita.softserve.course_evaluation_analytics.entity.TeacherRateCounter;
import ita.softserve.course_evaluation_analytics.service.CourseCounterService;
import ita.softserve.course_evaluation_analytics.service.TeacherCounterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/analytics/teacher")
public class TeacherController {
	private final TeacherCounterService teacherCounterService;
	private final CourseCounterService courseCounterService;
	
	public TeacherController(TeacherCounterService teacherCounterService, CourseCounterService courseCounterService) {
		this.teacherCounterService = teacherCounterService;
		this.courseCounterService = courseCounterService;
	}
	
	
	@GetMapping("/rate")
	public ResponseEntity<List<TeacherRateCounter>> getTeacherRate() {
		return ResponseEntity.status(HttpStatus.OK).body(teacherCounterService.getTeachersRate());
	}
	
	@GetMapping("/rate/{teacherId}")
	public ResponseEntity<TeacherRateCounter> getTeacherRate(@PathVariable long teacherId) {
		return ResponseEntity.status(HttpStatus.OK).body(teacherCounterService.getTeacherRate(teacherId));
	}
	
	@GetMapping("/rate/course/{courseId}")
	public ResponseEntity<Float> getCourseRate(@PathVariable long courseId) {
		return ResponseEntity.status(HttpStatus.OK).body(courseCounterService.getCourseRate(courseId));
	}
	@GetMapping("/rate/{teacherId}/questions")
	public ResponseEntity<List<TeacherQuestionRate>> getTeacherQuestionRate(@PathVariable long teacherId) {
		return ResponseEntity.status(HttpStatus.OK).body(teacherCounterService.getQuestionPatternRateByTeacherId(teacherId));
	}
	
}
