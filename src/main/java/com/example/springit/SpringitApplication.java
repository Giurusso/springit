package com.example.springit;

import com.example.springit.config.SpringitProperties;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import org.slf4j.Logger;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    @Profile("dev")
    CommandLineRunner commandLineRunner(){
        return args -> {
            log.error("Tacciii ! ");
            log.warn("Lote !!!!!!!! ");
            log.info("This is My log");
            log.debug("I m the king ");
            log.trace("A che cazzo serve ? ");
        };
    }
}
