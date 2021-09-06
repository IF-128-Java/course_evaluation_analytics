package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.Users;

import java.util.Optional;

public interface UsersRepository {

    Optional<Users> findByEmail(String email);
}
