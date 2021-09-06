package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.UserRoles;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRolesRepository {

    private DataSource dataSource;
    List<UserRoles>getAllUsersRoles(){
        List<UserRoles> roles = Collections.singletonList(new UserRoles());


        return roles;
    }
}
