package blackout.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;

@SpringBootApplication
@EnableEurekaClient
public class DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }


    @Autowired
    Environment env;

    @Bean
    public EntityManagerFactory entityManagerFactory() throws PropertyVetoException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("Blackout.shared.model");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    @Primary
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSoruce = new DriverManagerDataSource();
        dataSoruce.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSoruce.setUrl(env.getProperty("spring.datasource.url"));
        dataSoruce.setUsername(env.getProperty("spring.datasource.username"));
        dataSoruce.setPassword(env.getProperty("spring.datasource.password"));
        return dataSoruce;
    }

}
