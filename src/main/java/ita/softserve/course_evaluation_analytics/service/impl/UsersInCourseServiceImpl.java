package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.UsersInCourse;
import ita.softserve.course_evaluation_analytics.repository.UsersInCourseRepository;
import ita.softserve.course_evaluation_analytics.service.UsersInCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersInCourseServiceImpl implements UsersInCourseService {
    private final UsersInCourseRepository usersInCourseRepository;

    public UsersInCourseServiceImpl(UsersInCourseRepository usersInCourseRepository) {
        this.usersInCourseRepository = usersInCourseRepository;
    }

    @Override
    public List<UsersInCourse> countUsersInCourse() {
        return usersInCourseRepository.countUsersInCourse();
    }
}
