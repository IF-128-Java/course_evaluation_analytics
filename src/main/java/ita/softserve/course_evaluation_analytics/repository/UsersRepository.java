package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.Role;
import ita.softserve.course_evaluation_analytics.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {

    List<Role> findRoleByUserEmail(String email);
    Optional<Users> findByEmail(String email);
    Users findUserById(Long id);
}
