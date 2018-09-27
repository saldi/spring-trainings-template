package lab.spring.cepik.conf;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lab.spring.cepik.SystemPropertiesPresenter;
import lab.spring.cepik.activity.ActivityScope;
import lab.spring.cepik.activity.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = "lab.spring.cepik")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"lab.spring.cepik.driver"}, entityManagerFactoryRef = "emf")
//@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
//@EnableSpringConfigured

public class CepikConfiguration {

    @Autowired
    Environment env;

    @Bean
    @Scope(value = "activity", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserActivity userActivity() {
        return new UserActivity();
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


    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setShowSql(true);
        emf.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        emf.setPackagesToScan("lab.spring.cepik");

        return emf;
    }


    @Bean("dataSource")
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("jdbc.driver.url"));
        config.setUsername(env.getProperty("jdbc.driver.user"));
        config.setPassword(env.getProperty("jdbc.driver.password"));
        config.setDriverClassName("org.h2.Driver");
        config.setMaximumPoolSize(10);
        return new HikariDataSource(config);
    }


}
