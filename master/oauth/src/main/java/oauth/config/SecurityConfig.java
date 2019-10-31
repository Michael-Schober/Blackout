package oauth.config;

import oauth.auth.MyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    private MyDetailsService myDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
                .userDetailsService(myDetailsService)
                .passwordEncoder(passwordEncoder());
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
                .formLogin().and().csrf().disable();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
