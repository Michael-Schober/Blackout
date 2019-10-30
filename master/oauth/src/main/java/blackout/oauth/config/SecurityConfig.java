package blackout.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
                .inMemoryAuthentication()
                    .withUser("john")
                    .password(passwordEncoder().encode("password"))
                    .roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests().antMatchers("/oauth/token").permitAll()
                .and()
                .authorizeRequests().antMatchers("/oauth/authorize").authenticated()
                .and()
                .authorizeRequests().antMatchers("/oauth/check_token").authenticated()
                .and()
                .authorizeRequests().antMatchers("/oauth/token_key").authenticated()
                .and()
                .formLogin();
    }








    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
