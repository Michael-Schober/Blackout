package oauth.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.beans.PropertyVetoException;
import java.util.Arrays;


@Configuration
public class ServerConfig extends AuthorizationServerConfigurerAdapter
{

    @Autowired
    private ClientDetailsService clientDetailsService;




    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception
    {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter(), tokenEnhancer()));


        endpoints
                .tokenStore(tokenStore())
                .tokenEnhancer(tokenEnhancerChain)
                .userApprovalHandler(userApprovalHandler(tokenStore()));
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception
    {
        clients
                .jdbc(dataSource());
    }





    // JWT
    @Bean
    public TokenStore tokenStore()
    {
        return new JwtTokenStore(accessTokenConverter());
    }
    public TokenEnhancer tokenEnhancer() {return new CustomTokenEnhancer(); }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter()
    {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("key");
        return converter;
    }

    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore)
    {
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }

    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore)
    {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }

    //MySQL
    @Value("classpath:schema.sql")
    private Resource schemaScript;
    @Value("classpath:data.sql")
    private Resource dataScript;
    @Autowired
    private Environment env;

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
        dataSoruce.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSoruce.setUrl(env.getProperty("jdbc.url"));
        dataSoruce.setUsername(env.getProperty("jdbc.user"));
        dataSoruce.setPassword(env.getProperty("jdbc.pass"));
        return dataSoruce;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer()
    {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource());
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }
    private DatabasePopulator databasePopulator()
    {
        final ResourceDatabasePopulator populat = new ResourceDatabasePopulator();
        populat.addScript(schemaScript);
        populat.addScript(dataScript);
        return populat;
    }


}
