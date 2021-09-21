package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.TeacherQuestionRate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository {

    Optional<Float> getTeachersRate(Long teacherId);

    List<Long> getAllTeacher();

    List<Long> getAllTeacherCourses(Long teacherId);

    List<TeacherQuestionRate> getQuestionPatternRateByTeacherId(Long teacherId);
}
