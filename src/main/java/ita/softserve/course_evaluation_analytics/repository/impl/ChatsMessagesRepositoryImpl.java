package ita.softserve.course_evaluation_analytics.repository.impl;

import ita.softserve.course_evaluation_analytics.entity.ChatsMessages;
import ita.softserve.course_evaluation_analytics.mapper.ChatsMessagesResultSetExtractor;
import ita.softserve.course_evaluation_analytics.repository.ChatsMessagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChatsMessagesRepositoryImpl implements ChatsMessagesRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<ChatsMessages> getListOfMessagesByDays() {
        String sql = "SELECT dt_start AS days, count(cm.created_at) FILTER ( WHERE cm.chat_room_id = 3 ) AS teachers_messages, " +
                "count(cm.created_at) FILTER ( WHERE cm.chat_room_id != 3 ) AS groups_messages FROM " +
                "( SELECT dt_start, dt_start + INTERVAL '1 Day' dt_end FROM generate_series(current_date::timestamp " +
                "- interval '30 days', current_date::timestamp, '1 Day') AS dt_start ) AS r LEFT OUTER JOIN chat_messages cm " +
                "ON cm.created_at >= dt_start AND cm.created_at <  r.dt_end GROUP BY dt_start ORDER BY dt_start";
        return namedParameterJdbcTemplate.query(sql, new ChatsMessagesResultSetExtractor());
    }
}
