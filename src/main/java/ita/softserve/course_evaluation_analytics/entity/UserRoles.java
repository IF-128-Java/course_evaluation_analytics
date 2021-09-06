package ita.softserve.course_evaluation_analytics.entity;

import lombok.Data;

@Data
public class UserRoles {
    private long userId;
    private long roleId;
    private String roleName;
}
