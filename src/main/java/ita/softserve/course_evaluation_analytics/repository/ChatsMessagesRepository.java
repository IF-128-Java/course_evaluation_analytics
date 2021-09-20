package ita.softserve.course_evaluation_analytics.repository;

import ita.softserve.course_evaluation_analytics.entity.ChatsMessages;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatsMessagesRepository {
    List<ChatsMessages> getNumberOfMessagesByDay();
}
