package javacontroller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "javacontroller")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("com.mysql.jdbc.Driver");
        driver.setUrl("jdbc.mysql://localhost:3317/project_spring_mvc");
        driver.setUsername("root");
        driver.setPassword("NguyenVinh1906");
        return driver;
    }

    @Bean
    public CRUD_Controller getCRUD(){
        return new CRUD_Implement(getDataSource());
    }
}
