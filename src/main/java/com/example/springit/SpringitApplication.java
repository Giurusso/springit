package com.example.springit;

import com.example.springit.config.SpringitProperties;
import com.example.springit.domain.Comment;
import com.example.springit.domain.Link;
import com.example.springit.repository.CommentRepository;
import com.example.springit.repository.LinkRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import org.slf4j.Logger;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
        return args -> {
            Link link = new Link("Getting started with spring boot 2", "https://www.danvega.dev/docs/spring-boot-2-docs/#_mysql");
            linkRepository.save(link);

            Comment comment = new Comment("Fuck you and you mother !",link);

            commentRepository.save(comment);

            link.addComment(comment);


//            System.out.println(link.toString());
            System.out.println("We just insert a link in the comment");


        };
    }
}
