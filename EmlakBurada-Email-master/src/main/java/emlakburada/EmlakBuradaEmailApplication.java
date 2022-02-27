package emlakburada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"emlakburada.repository"})
public class EmlakBuradaEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakBuradaEmailApplication.class, args);
	}

}
