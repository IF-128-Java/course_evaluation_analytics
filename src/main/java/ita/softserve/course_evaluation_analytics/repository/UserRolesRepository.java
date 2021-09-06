package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.UserRoles;
import ita.softserve.course_evaluation_analytics.mapper.UserRolesMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRolesRepository {

    private static final String SQL_GET_ROLES = "SELECT ur.role_id, ur.user_id, r.role_name FROM user_roles ur LEFT JOIN role r on r.id = ur.role_id";
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<UserRoles>getAllUsersRoles(){
        List<UserRoles> roles = Collections.singletonList(new UserRoles());
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        return namedParameterJdbcTemplate.query(SQL_GET_ROLES, new UserRolesMapper());
    }
}
