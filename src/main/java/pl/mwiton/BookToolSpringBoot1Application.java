package pl.mwiton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.mwiton.model.Route;
import pl.mwiton.model.Ticket;
import pl.mwiton.service.GenericRepository;
import pl.mwiton.service.TicketRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class BookToolSpringBoot1Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(BookToolSpringBoot1Application.class, args);
	}
}
