package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.ChatsMessages;
import ita.softserve.course_evaluation_analytics.service.ChatsMessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin/analytics/spline-chart")
public class ChatsMessagesController {
    private final ChatsMessagesService chatsMessagesService;

    @GetMapping
    ResponseEntity<List<ChatsMessages>> getNumberOfMessagesByDays() {
        return ResponseEntity.status(HttpStatus.OK).body(chatsMessagesService.getListOfCountedMessagesByDays());
    }
}
