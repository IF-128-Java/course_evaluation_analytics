package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.GroupsCourses;

import java.util.List;

public interface ComplexChartService {
    List<GroupsCourses> countGroupsCoursesAndUsersFeedbacks();
}
