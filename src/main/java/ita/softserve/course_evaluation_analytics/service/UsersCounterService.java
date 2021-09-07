package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.UsersCounter;

import java.util.List;

public interface UsersCounterService {

    List<UsersCounter> countUsersByRoles();
}
