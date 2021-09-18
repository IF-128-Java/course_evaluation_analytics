package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.GroupsCourses;
import ita.softserve.course_evaluation_analytics.entity.UsersFeedbacks;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplexChartRepository {
    List<GroupsCourses> getCoursesInGroups();
    List<UsersFeedbacks> getFeedbacksFromUser();
}
