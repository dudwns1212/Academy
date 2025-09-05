package lx.edu.springmvc.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lx.edu.springmvc")
public class SpringConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/newhr");
		dataSource.setUsername("root");
		dataSource.setPassword("rootroot");
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext context) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setMapperLocations(context.getResources("classpath:mapper-*.xml"));
		org.apache.ibatis.session.Configuration configuration = 
				new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		factory.setConfiguration(configuration );
		
		return factory;
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
		SqlSessionTemplate template = new SqlSessionTemplate(factory);
		return template;
	}
}
