package oec.lis.sopl.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMssql",
        transactionManagerRef = "transactionManagerMssql",
        basePackages = {"oec.lis.sopl.model.cargowise.dao"}

)
public class MssqlDataSourceConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;
    @Autowired
    @Qualifier("dataSourceMssql")
    private DataSource mssqlDataSource;
    @Value("${spring.jpa.properties.hibernate.mssql-dialect}")
    private String mssqlDialect;

    /**
     * @param builder
     * @return
     */
    @Bean(name = "entityManagerFactoryMssql")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMssql(EntityManagerFactoryBuilder builder) {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.dialect", mssqlDialect);
        jpaProperties.setProperties(map);
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        return builder
                .dataSource(mssqlDataSource)
                .properties(properties)
                .packages("oec.lis.sopl.model.cargowise.dao.po")
                .build();
    }

    /**
     * TransactionManager
     *
     * @param builder
     * @return
     */
    @Bean(name = "transactionManagerMssql")
    @Primary
    PlatformTransactionManager transactionManagerMssql(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryMssql(builder).getObject());
    }

}