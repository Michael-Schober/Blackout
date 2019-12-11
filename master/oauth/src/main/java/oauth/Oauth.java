package oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.persistence.EntityManagerFactory;
import java.beans.PropertyVetoException;


@SpringBootApplication
@EnableEurekaClient
@EnableAuthorizationServer
@EntityScan("Blackout.shared.model.OauthUser")
public class Oauth
{
    public static void main(String[] args) {
        SpringApplication.run(Oauth.class, args);
    }


}



