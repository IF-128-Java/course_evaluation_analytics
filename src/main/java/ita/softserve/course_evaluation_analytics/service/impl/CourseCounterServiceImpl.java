package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.repository.CourseRepository;
import ita.softserve.course_evaluation_analytics.service.CourseCounterService;
import org.springframework.stereotype.Service;

@Service
public class CourseCounterServiceImpl implements CourseCounterService {

    private final CourseRepository courseRepository;

    public CourseCounterServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Float getCourseRate(long courseId) {
        return courseRepository.getCourseRateByCourseId(courseId);
    }
}
