package ita.softserve.course_evaluation_analytics.entity;

import lombok.Data;

@Data
public class UsersInCourse {

    public UsersInCourse() {
    }

    public UsersInCourse(String courseName, Long coursesUsers) {
        this.courseName = courseName;
        this.coursesUsers = coursesUsers;
    }

    private String courseName;
    private Long coursesUsers;
}
