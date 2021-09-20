package ita.softserve.course_evaluation_analytics.service;

import ita.softserve.course_evaluation_analytics.entity.ChatsMessages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatsMessagesService {
    List<ChatsMessages> getListOfCountedMessagesByDays();
}
