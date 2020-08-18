package com.example.springit;

import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
//        return args -> {
//            Link link = new Link("Getting started with spring boot 2", "https://www.danvega.dev/docs/spring-boot-2-docs/#_mysql");
//
//            linkRepository.save(link);
//
//            Comment comment = new Comment("Fuck you and you mother !",link);
//
//            commentRepository.save(comment);
//
//            link.addComment(comment);
//
//            System.out.println("We just insert a link in the comment");
//
//            System.out.println("**********************************************************");
//
//        };
//    }
    @Bean
    PrettyTime prettyTime(){
      return new PrettyTime();
    };
}
