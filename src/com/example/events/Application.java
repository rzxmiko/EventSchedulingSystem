package com.example.events;

import com.example.events.model.Event;
import com.example.events.model.Organizer;
import com.example.events.repository.EventRepository;
import com.example.events.repository.OrganizerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

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

            Organizer org1 = new Organizer("Astana Hub", 10);
            Organizer org2 = new Organizer("Arman Events", 5);
            Organizer org3 = new Organizer("Google Developers Group", 15);
            Organizer org4 = new Organizer("Music Hall", 3);
            Organizer org5 = new Organizer("Private Coach", 7);

            orgRepo.save(org1);
            orgRepo.save(org2);
            orgRepo.save(org3);
            orgRepo.save(org4);
            orgRepo.save(org5);

            eventRepo.save(new Event("Startup Battle 2024", 5000.0, LocalDate.now(), org1));
            eventRepo.save(new Event("AI Conference", 15000.0, LocalDate.now(), org1));
            eventRepo.save(new Event("Rock Festival", 25000.0, LocalDate.now(), org2));
            eventRepo.save(new Event("Evening Gala", 8500.0, LocalDate.now(), org2));
            eventRepo.save(new Event("Java Workshop", 0.0, LocalDate.now(), org3));
            eventRepo.save(new Event("DevFest Astana", 3500.0, LocalDate.now(), org3));
            eventRepo.save(new Event("Jazz Night", 1200.0, LocalDate.now(), org4));
            eventRepo.save(new Event("Piano Concert", 4500.0, LocalDate.now(), org4));
            eventRepo.save(new Event("Python for Beginners", 0.0, LocalDate.now(), org5));
            eventRepo.save(new Event("Career Coaching", 12000.0, LocalDate.now(), org5));

            System.out.println("----------------------------------------------");
            System.out.println(">>> Данные успешно загружены!");
            System.out.println(">>> Доступно организаторов: 5, Событий: 10");
            System.out.println(">>> Открой: http://localhost:8080/index.html");
            System.out.println("----------------------------------------------");
        };
    }
}