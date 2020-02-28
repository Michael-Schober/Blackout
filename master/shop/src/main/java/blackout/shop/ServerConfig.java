package blackout.shop;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class ServerConfig extends WebSecurityConfigurerAdapter
{


    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .cors().and()
                .authorizeRequests()
                .mvcMatchers("/shop").hasAuthority("SCOPE_shop")
                .mvcMatchers("/shop/admin").hasRole("ADMIN")
                .and()
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());
    }



    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
        return converter;
    }

    class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
        @Override
        public Collection<GrantedAuthority> convert(Jwt jwt) {
            final Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

            String scopes_unf = jwt.getClaim("scope");
            String scopes[] = scopes_unf.split(" ");

            List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

            auths.addAll(Arrays.stream(scopes)
                    .map(scope -> "SCOPE_" + scope)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList()));

            auths.addAll(((List<String>) realmAccess.get("roles")).stream()
                    .map(roleName -> "ROLE_" + roleName)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList()));

            System.out.println(auths);
            return auths;
        }
    }
}
