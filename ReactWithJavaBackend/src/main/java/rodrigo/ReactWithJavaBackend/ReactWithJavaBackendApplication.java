package rodrigo.ReactWithJavaBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactWithJavaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactWithJavaBackendApplication.class, args);
		System.out.println("Server on port 8080");
	}

}
