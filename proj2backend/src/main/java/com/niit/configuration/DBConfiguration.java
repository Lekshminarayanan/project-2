package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;
import com.niit.model.BlogPostLikes;
import com.niit.model.Job;
import com.niit.model.Notification;
import com.niit.model.ProfilePicture;
import com.niit.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit.configuration")
public class DBConfiguration {
public DBConfiguration() {
	System.out.println("DBConfiguration class is instantiated");
}
@Autowired
@Bean(name="sessionFactory")
 public SessionFactory sessionFactory() {
	LocalSessionFactoryBuilder lsf= new LocalSessionFactoryBuilder(getDataSource());
	Properties hibernateProperties=new Properties();
	hibernateProperties.setProperty("hibernate.dialect", "org.hibernatedialect.Oracle10gDialect");
	hibernateProperties.setProperty("hibernate.hbm2dd1.auto", "update");
	hibernateProperties.setProperty("hibernate.show_sql", "true");
	lsf.addProperties(hibernateProperties);
	Class classes[]=new Class[] {User.class,Job.class,BlogPost.class,Notification.class,BlogPostLikes.class,BlogComment.class,ProfilePicture.class};
	return lsf.addAnnotatedClasses(classes).buildSessionFactory();
}
@Autowired
@Bean(name="dataSource")
public DataSource getDataSource() {
	BasicDataSource  dataSource=new BasicDataSource();
	dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("system");
	dataSource.setPassword("password");
	return dataSource;
}
@Autowired
@Bean
public HibernateTransactionManager hibTransManagement() {
	return new HibernateTransactionManager(sessionFactory());
}
}
