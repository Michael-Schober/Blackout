package blackout.shop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableWebFluxSecurity
public class ServerConfig
{

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http)
    {
        http
                .cors().and()
                .authorizeExchange()
                .pathMatchers("/shop*").hasAuthority("SCOPE_shop")
                .pathMatchers("/shop/admin").hasRole("ADMIN")
                .and()
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());

        return http.build();
    }

    private Converter<Jwt, Mono<AbstractAuthenticationToken>> jwtAuthenticationConverter()
    {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
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
            return auths;
        }
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
