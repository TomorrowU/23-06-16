package com.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectAApplication.class, args);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
	        
	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        
	        sessionFactory.setDataSource(dataSource);
	        return sessionFactory.getObject();
	        
	    }
}