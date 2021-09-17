package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.GroupsCourses;
import ita.softserve.course_evaluation_analytics.entity.UsersFeedbacks;
import ita.softserve.course_evaluation_analytics.repository.ComplexChartRepository;
import ita.softserve.course_evaluation_analytics.service.ComplexChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComplexChartServiceImpl implements ComplexChartService {
    private final ComplexChartRepository complexChartRepository;

    public List<GroupsCourses> countGroupsCoursesAndUsersFeedbacks() {
        List<GroupsCourses> groupsCoursesList = complexChartRepository.getCoursesInGroups();
        for (GroupsCourses groupsCourses : groupsCoursesList) {
            List<UsersFeedbacks> usersFeedbacksList = complexChartRepository.getFeedbacksFromUser();
            List<UsersFeedbacks> filteredList =  usersFeedbacksList.stream()
                    .filter(o -> o.getGroup_id() == groupsCourses.getId())
                    .collect(Collectors.toList());
            groupsCourses.setUsers_feedbacks(filteredList);
        }

        return groupsCoursesList;
    }

}
