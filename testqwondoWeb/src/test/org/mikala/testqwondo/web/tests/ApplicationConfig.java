package org.mikala.testqwondo.web.tests;

import java.util.Properties;

import javax.faces.webapp.FacesServlet;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"org.mikala.testqwondo.spring.repository",
    "org.mikala.testqwondo.spring.services"})
@EnableJpaRepositories(basePackages = {"org.mikala.testqwondo.spring.repository",
    "org.mikala.testqwondo.spring.services"})
// @EnableTransactionManagement
class ApplicationConfig {



  /*
   * @Bean public EmbeddedServletContainerFactory servletContainer() {
   * TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
   * factory.setPort(9009); factory.setSessionTimeout(10, TimeUnit.MINUTES);
   * //factory.addErrorPages(new ErrorPage(HttpStatus.404, "/notfound.html")); return factory; }
   */

  @Bean
  public ServletRegistrationBean servletRegistrationBean() {
    FacesServlet servlet = new FacesServlet();
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
    return servletRegistrationBean;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource driver = new DriverManagerDataSource();
    driver.setDriverClassName("org.postgresql.Driver");
    driver.setUrl("jdbc:postgresql://localhost:5432/testqwondo");
    driver.setUsername("postgres");
    driver.setPassword("resist");
    return driver;
  }

  @Bean
  public EntityManagerFactory entityManagerFactory() {

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    vendorAdapter.setGenerateDdl(true);

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("org.mikala.testqwondo.api.model");
    factory.setDataSource(dataSource());
    // factory.setMappingResources("orm.xml");
    factory.setJpaProperties(additionalProperties());
    factory.afterPropertiesSet();
    return factory.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager() {

    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory());
    txManager.setNestedTransactionAllowed(true);
    return txManager;
  }

  Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
    properties.setProperty("spring.jpa.hibernate.ddl-auto", "create-drop");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    return properties;
  }
}
