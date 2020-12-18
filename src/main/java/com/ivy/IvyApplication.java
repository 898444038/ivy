package com.ivy;

import com.ivy.system.config.CrosFilter;
import com.ivy.tools.generate.template.enable.EnableGenerate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@MapperScan(basePackages = {
	"com.ivy.admin.mapper",
})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableGenerate(basePackages = {
	"com.ivy.admin"
})
public class IvyApplication {

	public static void main(String[] args) {
		SpringApplication.run(IvyApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean registerFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.addUrlPatterns("/*");
		bean.setFilter(new CrosFilter());
		return bean ;
	}
}
