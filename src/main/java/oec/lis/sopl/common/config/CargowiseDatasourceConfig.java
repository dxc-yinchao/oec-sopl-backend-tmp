package oec.lis.sopl.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class CargowiseDatasourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.cargowise")
    public DataSourceProperties cargowiseDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.cargowise.hikari")
    public DataSource cargowiseDataSource() {
        return cargowiseDataSourceProperties()
            .initializeDataSourceBuilder()
            .build();
    }

    @Bean
    public JdbcTemplate cargowiseJdbcTemplate(@Qualifier("cargowiseDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
