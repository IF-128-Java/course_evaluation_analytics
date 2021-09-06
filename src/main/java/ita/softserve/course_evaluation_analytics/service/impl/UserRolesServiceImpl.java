package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.UserRoles;
import ita.softserve.course_evaluation_analytics.repository.UserRolesRepository;
import ita.softserve.course_evaluation_analytics.service.UserRolesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesServiceImpl implements UserRolesService {
    private UserRolesRepository userRolesRepository;

    public UserRolesServiceImpl(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public List<UserRoles> getAllRolesByUsersId() {
        return userRolesRepository.getAllUsersRoles();
    }
}
