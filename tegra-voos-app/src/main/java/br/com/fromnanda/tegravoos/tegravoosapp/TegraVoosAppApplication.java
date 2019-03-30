package br.com.fromnanda.tegravoos.tegravoosapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "br.com.fromnanda.tegravoos.tegravoosapp" })
public class TegraVoosAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TegraVoosAppApplication.class, args);
	}

}
