package ntou.soselab.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TheaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheaterApplication.class, args);
	}
}
