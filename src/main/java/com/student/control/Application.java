package com.student.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.student.control.models.User;
import com.student.control.repositories.UserRepository;
import com.student.control.views.Login;
import com.student.control.views.Main;

@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;
    
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .headless(false).run(args);
    }

    @Bean
    public void applicationRunner() {

        if (userRepository.count() == 0) {
            User user = new User();

            user.setFirstName("Usuario");
            user.setLastName("AdminisUsuariotrador");
            user.setEmail("user@mail.com");
            user.setPassword("123456789");

            userRepository.save(user);
        }
        new Main(userRepository, "Pepito").setVisible(true);
    }
}
