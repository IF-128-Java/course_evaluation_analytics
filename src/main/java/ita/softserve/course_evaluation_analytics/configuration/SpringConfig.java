package ita.softserve.course_evaluation_analytics.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import  org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Value("${spring.datasource.username}")
    private String login;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(login);
        dataSource.setPassword(password);
        return dataSource;
    }
}
