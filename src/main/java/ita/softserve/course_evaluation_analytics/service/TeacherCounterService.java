package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.TeacherQuestionRate;
import ita.softserve.course_evaluation_analytics.entity.TeacherRateCounter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherCounterService {
	
	List<TeacherRateCounter> getTeachersRate();
	TeacherRateCounter getTeacherRate(long teacherId);
	List<TeacherQuestionRate> getQuestionPatternRateByTeacherId(long teacherId);
}
