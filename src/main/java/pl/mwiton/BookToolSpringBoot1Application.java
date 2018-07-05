package pl.mwiton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.mwiton.model.Route;
import pl.mwiton.model.Ticket;
import pl.mwiton.service.GenericRepository;
import pl.mwiton.service.TicketRepository;
import pl.mwiton.transaction.TicketsTransactionManager;

import java.time.LocalDateTime;

@SpringBootApplication
public class BookToolSpringBoot1Application {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(BookToolSpringBoot1Application.class, args);
		Route route = new Route("Szczecin", "Stargard", 30, LocalDateTime.of(2018,3,12,0,0));
		RouteDao routeDao = context.getBean(RouteDao.class);
		routeDao.save(route);
		TicketsTransactionManager manager = context.getBean(TicketsTransactionManager.class);
		String id = manager.makeTransaction(routeDao.getRoute(1), 2);
		GenericRepository<String, Ticket> repository = context.getBean(TicketRepository.class);
		repository.get(id);
        context.close();
	}
}
