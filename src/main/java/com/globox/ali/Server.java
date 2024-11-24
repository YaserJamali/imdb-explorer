package com.globox.ali;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = "com.globox.ali")
@EnableJpaRepositories
@EnableTransactionManagement
public class Server {

    public static void main(String[] args) {


        SpringApplication.run(Server.class, args);
    }

}
