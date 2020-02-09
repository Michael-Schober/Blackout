package blackout.shop;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ServerConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http    .cors().and()
                .authorizeRequests()
                .mvcMatchers("/**").hasAuthority("SCOPE_read_appointment")
                .anyRequest().denyAll()
                .and()
                .oauth2ResourceServer().jwt();
    }
}
