package ita.softserve.course_evaluation_analytics.config;

import ita.softserve.course_evaluation_analytics.repository.AnalystRepository;
import ita.softserve.course_evaluation_analytics.repository.impl.AnalystRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public AnalystRepository analystrepository() {
        return new AnalystRepositoryImpl();
    }


    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema-h2.sql")
                .addScript("test-data.sql")
                .addScript("feedbackrequest.sql")
                .addScript("feedbackrequestdata.sql")
                .addScript("answertofeedback.sql")
                .addScript("course_feedback.sql")
                .addScript("course_feedbackdata.sql")
                .addScript("answertofeedbackdata.sql")
                .build();
    }
}
