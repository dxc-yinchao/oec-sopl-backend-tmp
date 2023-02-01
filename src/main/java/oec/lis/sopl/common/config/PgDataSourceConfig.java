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
        entityManagerFactoryRef = "entityManagerFactoryPg",
        transactionManagerRef = "transactionManagerPg",
        basePackages = {"oec.lis.sopl.model.sopl.dao"}
)
public class PgDataSourceConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;
    @Autowired
    @Qualifier("dataSourcePg")
    private DataSource PgDataSource;
    @Value("${spring.jpa.properties.hibernate.pg-dialect}")
    private String pgDialect;

    /**
     * @param builder
     * @return
     */
    @Bean(name = "entityManagerFactoryPg")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPg(EntityManagerFactoryBuilder builder) {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.dialect", pgDialect);
        jpaProperties.setProperties(map);
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        return builder
                .dataSource(PgDataSource)
                .properties(properties)
                .packages("oec.lis.sopl.model.sopl.dao.po")
                .build();
    }

    /**
     * TransactionManagerPg
     *
     * @param builder
     * @return
     */
    @Bean(name = "transactionManagerPg")
    PlatformTransactionManager transactionManagerPg(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPg(builder).getObject());
    }

}