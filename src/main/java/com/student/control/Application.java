package com.student.control;

import com.student.control.repositories.UserRepository;
import com.student.control.views.Login;
import com.student.control.views.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .headless(false).run(args);
    }

    @Bean
    /*public void applicationRunner() {
        new Main(userRepository).setVisible(true);
    }*/
    public  void  prueba(){
        new Login(userRepository).setVisible(true);
    }
}
