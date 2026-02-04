package com.example.events;
import com.example.events.model.Event;
import com.example.events.model.Organizer;
import com.example.events.repository.EventRepository;
import com.example.events.repository.OrganizerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(EventRepository eventRepo, OrganizerRepository orgRepo) {
        return (args) -> {
            eventRepo.deleteAll();
            orgRepo.deleteAll();

            Organizer org = new Organizer("Arman", 5);
            orgRepo.save(org);

            eventRepo.save(new Event("Rock Concert", 1500.0, org));
            eventRepo.save(new Event("Java Workshop", 0.0, org));

            System.out.println("Система готова!");
        };
    }
}