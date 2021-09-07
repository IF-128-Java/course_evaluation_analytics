package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.UsersCounter;
import ita.softserve.course_evaluation_analytics.repository.UsersCounterRepository;
import ita.softserve.course_evaluation_analytics.service.UsersCounterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersCounterServiceImpl implements UsersCounterService {
    private final UsersCounterRepository usersCounterRepository;

    public UsersCounterServiceImpl(UsersCounterRepository usersCounterRepository) {
        this.usersCounterRepository = usersCounterRepository;
    }

    @Override
    public List<UsersCounter> countUsersByRoles() {
        return usersCounterRepository.countUserRoles();
    }
}
