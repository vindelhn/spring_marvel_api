package com.siman.marvel_api;

import com.siman.marvel_api.model.User;
import com.siman.marvel_api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class MarvelApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarvelApiApplication.class, args);
    }


    @Bean
    protected CommandLineRunner init(final UserRepository userRepository) {

        return args -> {

            User user1 = new User();
            user1.setUsername("admin");
            user1.setPassword("admin");
            user1.setName("Admin User");
            userRepository.save(user1);

            User user2 = new User();
            user2.setUsername("test");
            user2.setPassword("test");
            user2.setName("Test User");
            userRepository.save(user2);



        };
    }

}
