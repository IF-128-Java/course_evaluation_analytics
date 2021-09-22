package ita.softserve.course_evaluation_analytics.service;

import org.springframework.stereotype.Service;

@Service
public interface CourseCounterService {
    Float getCourseRate(long courseId);
}

