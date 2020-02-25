package blackout.shop;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ServerConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http    .cors().and()
                .authorizeRequests()
                .mvcMatchers("/**").hasAuthority("SCOPE_shop")
                .anyRequest().denyAll()
                .and()
                .oauth2ResourceServer().jwt();
    }
}
