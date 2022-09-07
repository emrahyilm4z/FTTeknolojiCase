package com.emrah.ftteknoloji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableMongoRepositories("com.emrah.ftteknoloji.dataAcces")
@EnableWebMvc
public class FtTeknolojiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FtTeknolojiApplication.class, args);
    }

}
