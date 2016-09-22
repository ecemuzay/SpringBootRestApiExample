package rest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "rest")
public class SpringRestExampleApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(SpringRestExampleApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8090").
						allowedMethods("PUT", "DELETE", "GET", "POST").maxAge(3600)
				.allowedHeaders("x-requested-with");
			}
		};
	}

}
