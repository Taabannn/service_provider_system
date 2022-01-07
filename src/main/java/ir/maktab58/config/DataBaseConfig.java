package ir.maktab58.config;

import ir.maktab58.data.models.Address;
import ir.maktab58.data.models.Comment;
import ir.maktab58.data.models.Offer;
import ir.maktab58.data.models.Order;
import ir.maktab58.data.models.services.MainService;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import ir.maktab58.data.models.users.User;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Taban Soleymani
 */
@PropertySource("classpath:database.properties")
@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
public class DataBaseConfig {

    private SessionFactory sessionFactory;

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

    @Bean("sessionFactory")
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
    }
}
