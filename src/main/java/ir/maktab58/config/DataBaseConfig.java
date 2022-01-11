package ir.maktab58.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Taban Soleymani
 */
@EnableJpaRepositories(basePackages = "ir.maktab58.data.dao")
@PropertySource("classpath:database.properties")
@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
public class DataBaseConfig {
    @Autowired
    private Environment environment;

    @Value("${db.driver}")
    String driver;
    @Value("${db.url}")
    String url;
    @Value("${db.user}")
    String user;
    @Value("${db.password}")
    String pass;
    @Value("${hibernate.dialect}")
    String dialect;
    @Value("${hibernate.show_sql}")
    String sql;
    @Value("${hibernate.hbm2ddl.auto}")
    String hbm2ddl;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty(driver));
        dataSource.setUrl(environment.getProperty(url));
        dataSource.setUsername(environment.getProperty(user));
        dataSource.setPassword(environment.getProperty(pass));
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("ir.maktab58.data.model");

        entityManagerFactoryBean.setJpaProperties(hibernateProperties());

        return entityManagerFactoryBean;
    }

    private Properties hibernateProperties(){
        Properties jpaProperties = new Properties();
        jpaProperties.put(dialect, environment.getRequiredProperty("hibernate.dialect"));
        jpaProperties.put(hbm2ddl, environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        //jpaProperties.put("hibernate.ejb.naming_strategy", environment.getRequiredProperty("hibernate.ejb.naming_strategy"));
        jpaProperties.put(sql, environment.getRequiredProperty("hibernate.show_sql"));
        //jpaProperties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return jpaProperties;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    /*@Bean("sessionFactory")
    public  SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.setProperties(getProperties());

                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Manager.class);
                configuration.addAnnotatedClass(Expert.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(MainService.class);
                configuration.addAnnotatedClass(SubService.class);
                configuration.addAnnotatedClass(Address.class);
                configuration.addAnnotatedClass(Comment.class);
                configuration.addAnnotatedClass(Offer.class);
                configuration.addAnnotatedClass(Order.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private Properties getProperties() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, driver);
        settings.put(Environment.URL, url);
        settings.put(Environment.USER, user);
        settings.put(Environment.PASS, pass);
        settings.put(Environment.DIALECT, dialect);
        settings.put(Environment.SHOW_SQL, sql);
        settings.put(Environment.HBM2DDL_AUTO, hbm2ddl);
        return settings;
    }*/
}
