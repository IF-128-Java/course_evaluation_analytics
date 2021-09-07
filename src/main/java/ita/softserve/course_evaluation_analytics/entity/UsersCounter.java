package ita.softserve.course_evaluation_analytics.entity;

import lombok.Data;

@Data
public class UsersCounter {
    public UsersCounter(long adminRoles, long teacherRoles, long studentRoles, long noRoles) {
        this.adminRoles = adminRoles;
        this.teacherRoles = teacherRoles;
        this.studentRoles = studentRoles;
        this.noRoles = noRoles;
    }

    private long adminRoles;
    private long teacherRoles;
    private long studentRoles;
    private long noRoles;

}
