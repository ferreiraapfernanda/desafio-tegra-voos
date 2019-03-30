package br.com.fromnanda.tegravoos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.fromnanda" })
public class TegraVoosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TegraVoosApplication.class, args);
	}

}
