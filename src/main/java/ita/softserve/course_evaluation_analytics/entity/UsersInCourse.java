package ita.softserve.course_evaluation_analytics.entity;

import lombok.Data;

@Data
public class UsersInCourse {

    public UsersInCourse() {
    }

    public UsersInCourse(String courseName, Long usersInCourse) {
        this.courseName = courseName;
        this.usersInCourse = usersInCourse;
    }

    private String courseName;
    private Long usersInCourse;
}
