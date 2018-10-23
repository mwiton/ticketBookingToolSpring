package pl.mwiton.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.mwiton.model.Ticket;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Witoń on 07.03.2018.
 */
@Component
public interface TicketRepository extends CrudRepository<Ticket, String> {

}
