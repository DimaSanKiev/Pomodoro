package pomodoro.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "pomodoro.dao")
@PropertySource("application.properties")
public class DataConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(env.getProperty("pomodoro.entity.package"));
        factory.setJpaProperties(getHibernateProperties());

        return factory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("pomodoro.db.driver"));
        dataSource.setUrl(env.getProperty("pomodoro.db.url"));
        dataSource.setUsername(env.getProperty("pomodoro.db.username"));
        dataSource.setPassword(env.getProperty("pomodoro.db.password"));
        return dataSource;
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        prop.put("hibernate.implicit_naming_strategy", env.getProperty("hibernate.implicit_naming_strategy"));
        prop.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        prop.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        prop.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        return prop;
    }
}
