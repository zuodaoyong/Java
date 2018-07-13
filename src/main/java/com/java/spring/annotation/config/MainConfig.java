package com.java.spring.annotation.config;

import javax.servlet.annotation.WebFilter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import com.java.spring.annotation.bean.User;
import com.java.spring.annotation.condition.UserCondition;
import com.java.spring.annotation.imports.UserImportBeanDefinitionRegistrar;
import com.java.spring.annotation.imports.UserImportSelector;
import com.java.spring.annotation.typefilter.UserTypeFilter;


@Configuration
@ComponentScan(basePackages={"com.java.spring.annotation"},
includeFilters={
		@Filter(type=FilterType.ANNOTATION,classes={Bean.class}),
		@Filter(type=FilterType.CUSTOM,classes={UserTypeFilter.class})
        },
/*excludeFilters={
		@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={User.class})}*/
       useDefaultFilters=false
		)
/*@Import({User.class})*/
/*@Import({UserImportSelector.class})*/
@Import({UserImportBeanDefinitionRegistrar.class})
public class MainConfig {

	public static void main(String[] args) {
		ApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
	    String[] names = configApplicationContext.getBeanDefinitionNames();
	    for (String name : names) {
			System.out.println("name:"+name);
		}
	}
	
	/*@Conditional({UserCondition.class})
    @Bean
	public User user(){
		return new User();
	}*/
}
