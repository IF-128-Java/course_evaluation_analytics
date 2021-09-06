package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.UserRoles;

import java.util.List;

public interface UserRolesService {
    List<UserRoles> getAllRolesByUsersId();
}
