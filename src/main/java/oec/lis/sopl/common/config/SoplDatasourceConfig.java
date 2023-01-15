package oec.lis.sopl.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SoplDatasourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.sopl")
    public DataSourceProperties soplDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.sopl.hikari")
    public DataSource soplDataSource() {
        return soplDataSourceProperties()
            .initializeDataSourceBuilder()
            .build();
    }

    @Bean
    public JdbcTemplate soplJdbcTemplate(@Qualifier("soplDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
