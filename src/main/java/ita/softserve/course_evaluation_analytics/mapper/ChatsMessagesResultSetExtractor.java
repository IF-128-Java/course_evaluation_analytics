package ita.softserve.course_evaluation_analytics.mapper;


import ita.softserve.course_evaluation_analytics.entity.ChatsMessages;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatsMessagesResultSetExtractor implements RowMapper<ChatsMessages> {
    private static final String DAYS = "days";
    private static final String TEACHERS_MESSAGES = "teachers_messages";
    private static final String GROUPS_MESSAGES = "groups_messages";

    @Override
    public ChatsMessages mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ChatsMessages(resultSet.getTimestamp(DAYS).toLocalDateTime(),
                resultSet.getLong(TEACHERS_MESSAGES),
                resultSet.getLong(GROUPS_MESSAGES));
    }
}
