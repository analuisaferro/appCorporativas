package br.cefetrj;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class HotelariaApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(HotelariaApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HotelariaApplication.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterInit() throws IOException, URISyntaxException, ClassNotFoundException {
        System.out.println("Aplicação iniciada com sucesso!");
    }

}