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
//        System.out.println("This is my merge test ! ");
//        System.out.println("Welcome to Springit !");
    }

    @Bean
    @Profile("dev")
    CommandLineRunner commandLineRunner(){
        return args -> {
            log.error("Allanem e kivemmuort ! ");
            log.warn("Lote !!!!!!!! ");
            log.info("This is My log");
            log.debug("I m the king ");
            log.trace("A che cazzo serve ? ");
        };
    }

//    @Bean
//    @Profile("dev")
//    CommandLineRunner runner(){
//        return args -> {
//            System.out.println("Welcome Message: " + springitProperties.getWelkomeMsg());
//        };
//    }
//
//    @Bean
//    @Profile("dev")
//    CommandLineRunner runner2() {
//        return args -> {
//            System.out.println("This is somethink that we do only in dev ");
//        };
//    }

//    @Bean
//    @Profile("dev")
//    CommandLineRunner runner3() {
//        return args -> {
//            System.out.println("Printing all the bean names in the application context. ");
//            System.out.println("--------------------------------------------------------");
//            String[] beans=applicationContext.getBeanDefinitionNames();
//            Stream<String> collection = Arrays.stream(beans);
//            collection.sorted().forEach(s -> System.out.println(s));
//
//
//        };
//    }

}
