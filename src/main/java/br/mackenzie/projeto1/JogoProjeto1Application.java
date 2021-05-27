package br.mackenzie.projeto1;

import br.mackenzie.projeto1.controller.JogoController;
import br.mackenzie.projeto1.entity.Jogo;
import br.mackenzie.projeto1.repository.JogoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class JogoProjeto1Application {

    public static void main(String[] args) {

        SpringApplication.run(JogoProjeto1Application.class, args);
    }
}
