package com.springhibxml.startup;
import java.util.Properties;

import javax.annotation.*;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("com.springhibxml")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class WebServletDescriptorconfig {
	private static final String PROPERTY_NAME_DATABASE_DRIVER="db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD="db.password";
	private static final String PROPERTY_NAME_DATABASE_URL="db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME="db.username";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT="hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL="hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGE_TO_SCAN="entitymanager.packages.to.scan";

	
	@Resource
	private Environment env;


	@Bean
	public DataSource dataSource(){
	DriverManagerDataSource datasource=new DriverManagerDataSource();
	//set all the required variables from external properties file here
	datasource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
	datasource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
	datasource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
	datasource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

	return datasource;
	}
	private Properties hibProperties() {
	Properties properties = new Properties();
	properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
	properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
	return properties;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory(){

	LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
	sessionFactoryBean.setDataSource(dataSource());
	sessionFactoryBean.setHibernateProperties(hibProperties());
	sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGE_TO_SCAN));
	return sessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager transactionManager(){
	HibernateTransactionManager transactionManagerBean=new HibernateTransactionManager();
	transactionManagerBean.setSessionFactory(sessionFactory().getObject());
	return transactionManagerBean;
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver(){
	UrlBasedViewResolver urlViewResolver=new UrlBasedViewResolver();
	urlViewResolver.setPrefix("/WEB-INF/views/");
	urlViewResolver.setSuffix(".jsp");
	urlViewResolver.setViewClass(JstlView.class);
	return urlViewResolver;
	}}
