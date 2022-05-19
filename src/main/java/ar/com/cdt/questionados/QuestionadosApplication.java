package ar.com.cdt.questionados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuestionadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionadosApplication.class, args);
	}
}
