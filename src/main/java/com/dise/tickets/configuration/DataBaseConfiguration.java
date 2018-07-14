package com.dise.tickets.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement // transacciones en la bd
public class DataBaseConfiguration {
	
	@Bean 
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource()); // datos de configuracion BD
		//Donde se hara el mapping de las clases
		sessionFactory.setPackagesToScan("com.dise.tickets.entity");
		//Añadiendo propiedades de hibernate 
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		
	}
	
	@Bean
	public DataSource dataSource() { // configuira datos de conexion
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/heroku_ccf4d83b0f4446b?useSSL=false");
//		dataSource.setUsername("b4986a9338ddd7");
//		dataSource.setPassword("aaafde94");
		dataSource.setUrl("jdbc:mysql://localhost:3306/easyTicket?useSSL=false");
		dataSource.setUsername("userdev");
		dataSource.setPassword("password");
		return dataSource;
	}
	
	//metodo de propiedades de hibernate 
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("show_sql", "true");
		
		
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibernateTransactionManager;
		
	}
}
