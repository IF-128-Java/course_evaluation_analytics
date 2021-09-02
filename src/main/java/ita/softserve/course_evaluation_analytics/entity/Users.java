package ita.softserve.course_evaluation_analytics.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Users {

    public Users(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<Role> roles;

//    private Group group;

//    private Set<Course> teachCourses;

}
