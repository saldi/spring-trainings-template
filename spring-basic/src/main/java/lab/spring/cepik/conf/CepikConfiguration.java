package lab.spring.cepik.conf;


import lab.spring.cepik.SystemPropertiesPresenter;
import lab.spring.cepik.activity.ActivityScope;
import lab.spring.cepik.activity.UserActivity;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = "lab.spring")
public class CepikConfiguration {

    @Bean
    @Scope("activity")
    public UserActivity userActivity() {
        return new UserActivity();
    }


    @Bean
    public Supplier<UserActivity> userActivitySupplier() {
        return () -> {
            return userActivity();
        };
    }

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("activity", new ActivityScope());
        return customScopeConfigurer;
    }

    @Bean
    public SystemPropertiesPresenter systemPropertiesPresenter() {
        return new SystemPropertiesPresenter();
    }

    @Bean
    public RunnableBeanPostProcessor runnableBeanPostProcessor() {
        return new RunnableBeanPostProcessor(executorService());
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors());
    }


    @Bean("dataSource")
    public DataSource dataSource() {
        return new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                return null;
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                return null;
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {

            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {

            }

            @Override
            public int getLoginTimeout() throws SQLException {
                return 0;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        };

    }


}
