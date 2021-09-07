package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.UsersCounter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersCounterRepository {
    List<UsersCounter> countUserRoles();
}
