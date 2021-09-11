package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.UsersInCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersInCourseService {
    List<UsersInCourse> countUsersInCourse();
}
