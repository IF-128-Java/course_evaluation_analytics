package ita.softserve.course_evaluation_analytics.service;

import org.springframework.stereotype.Repository;

@Repository
public interface CourseCounterService {
	Float getCourseRate(long courseId);
}

