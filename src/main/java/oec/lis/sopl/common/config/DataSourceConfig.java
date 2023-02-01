package oec.lis.sopl.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean("dataSourceMssql")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.cargowise")
    public DataSource dataSourceMssql() {
        return DataSourceBuilder.create().build();
    }


    @Bean("dataSourcePg")
    @ConfigurationProperties(prefix = "spring.datasource.sopl")
    public DataSource dataSourcePg() {
        return DataSourceBuilder.create().build();
    }
}
