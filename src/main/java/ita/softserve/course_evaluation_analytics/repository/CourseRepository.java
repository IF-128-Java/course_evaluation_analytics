package ita.softserve.course_evaluation_analytics.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {
	Float getCourseRateByCourseId(long courseId);
	
}
