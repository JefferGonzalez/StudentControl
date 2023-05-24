package com.student.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.student.control.models.User;
import com.student.control.models.Periodo;
import com.student.control.models.Corte;
import com.student.control.models.Calificacion;
import com.student.control.repositories.CalificacionRepository;
import com.student.control.repositories.CorteRepository;
import com.student.control.repositories.NotasRepository;
import com.student.control.repositories.PeriodoRepository;
import com.student.control.repositories.UserRepository;
import com.student.control.services.EmailService;
import com.student.control.views.Login;
import com.student.control.views.Main;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PeriodoRepository periodoRepository;

    @Autowired
    private CorteRepository corteRepository;

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Autowired
    private NotasRepository notasRepository;

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .headless(false).run(args);
    }

    @Bean
    public void applicationRunner() {

        if (userRepository.count() == 0) {

            periodoRepository.saveAll(Arrays.asList(
                    new Periodo(null, "PERIODO I", null, null),
                    new Periodo(null, "PERIODO II", null, null),
                    new Periodo(null, "PERIODO III", null, null),
                    new Periodo(null, "PERIODO IV", null, null),
                    new Periodo(null, "PERIODO V", null, null),
                    new Periodo(null, "PERIODO VI", null, null),
                    new Periodo(null, "PERIODO VII", null, null),
                    new Periodo(null, "PERIODO VIII", null, null),
                    new Periodo(null, "PERIODO IX", null, null),
                    new Periodo(null, "PERIODO X", null, null),
                    new Periodo(null, "PERIODO XI", null, null),
                    new Periodo(null, "PERIODO XII", null, null)));

            Optional<Periodo> periodo = periodoRepository.findByNombre("PERIODO I");

            corteRepository.saveAll(Arrays.asList(
                    new Corte(null, "CORTE 1", 20, null, periodo.get()),
                    new Corte(null, "CORTE 2", 30, null, periodo.get()),
                    new Corte(null, "CORTE 3", 50, null, periodo.get())));

            Optional<Corte> corte = corteRepository.findById(1);

            calificacionRepository.saveAll(Arrays.asList(
                    new Calificacion(null, "QUIZ", 20, corte.get()),
                    new Calificacion(null, "TALLERES", 30, corte.get()),
                    new Calificacion(null, "TAREAS", 30, corte.get()),
                    new Calificacion(null, "ACT.PRACTICA", 30, corte.get())
            ));

            User user = new User();

            user.setFirstName("Usuario");
            user.setLastName("Administrador");
            user.setEmail("user@mail.com");
            user.setPassword("123456789");

            userRepository.save(user);
        }
        new Main(userRepository, periodoRepository, corteRepository, calificacionRepository, notasRepository, emailService, "Pepito")
                .setVisible(true);
        // new Login(userRepository, periodoRepository, corteRepository,
        //         calificacionRepository, notasRepository, emailService).setVisible(true);
    }
}
