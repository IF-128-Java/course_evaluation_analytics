package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.UserInfo;

import java.util.List;

public interface UserInfoRepository {

    List<UserInfo> findUserInfoByRoleId();

}
