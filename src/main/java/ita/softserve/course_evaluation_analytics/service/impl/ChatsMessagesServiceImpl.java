package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.ChatsMessages;
import ita.softserve.course_evaluation_analytics.repository.ChatsMessagesRepository;
import ita.softserve.course_evaluation_analytics.service.ChatsMessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChatsMessagesServiceImpl implements ChatsMessagesService {
    private final ChatsMessagesRepository chatsMessagesRepository;
    @Override
    public List<ChatsMessages> countMessagesByDays() {
        return chatsMessagesRepository.getNumberOfMessagesByDay();
    }
}
