package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.FeedbackInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackInfoRepository {

    List<FeedbackInfo> findFeedbackInfoByCourseId(Long id);

}
