package ita.softserve.course_evaluation_analytics.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository {
	
	Optional<Float> getTeachersRate(Long teacherId);
	List<Long> getAllTeacher();
	List<Long> getAllTeacherCourses(Long teacherId);
}
