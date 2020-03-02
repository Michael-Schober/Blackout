package blackout.userinfo;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.dialect.MySqlDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@EnableR2dbcRepositories
public class ReactiveConfig extends AbstractR2dbcConfiguration
{
    @Bean
    public R2dbcRepositoryFactory r2dbcRepositoryFactory() {
        RelationalMappingContext context = new RelationalMappingContext();
        context.afterPropertiesSet();
        return new R2dbcRepositoryFactory(databaseClient(), new DefaultReactiveDataAccessStrategy(new MySqlDialect()));
    }

    @Bean
    public DatabaseClient databaseClient() {
        return DatabaseClient.create(connectionFactory());
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactoryOptions opts = ConnectionFactoryOptions.builder()
                .option(HOST, "37.252.191.48")
                .option(DRIVER, "mysql")
                .option(USER, "ServiceUser")
                .option(PORT, 3306)
                .option(PASSWORD, "password")
                .option(DATABASE, "suitcase")
                .option(SSL, false)
                .build();

        return ConnectionFactories.get(opts);
    }
}
