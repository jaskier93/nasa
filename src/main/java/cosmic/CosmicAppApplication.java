package cosmic;

import cosmic.models.Planet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class CosmicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmicAppApplication.class, args);
	}

}
