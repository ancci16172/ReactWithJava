package rodrigo.ReactWithJavaBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReactWithJavaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactWithJavaBackendApplication.class, args);
		System.out.println("Server on port 8080");
	}



}
