package rest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "rest")
public class SpringRestExampleApplication {
    
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestExampleApplication.class, args);

	}

}
